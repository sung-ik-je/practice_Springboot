import json
import re
import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# 영어 단어 추출 함수
def extract_english_words(text):
    return re.findall(r'[a-zA-Z]+', text)

# 텍스트 파일 읽기 (예시: info_data.txt)
with open("info_data.txt", "r", encoding="utf-8") as txt_file:
    job_lines = txt_file.readlines()

# ChromeDriver 설정
driver = webdriver.Chrome()

# 전체 영어 단어 통계용 데이터
agg_data = {}

# 상세 페이지에서 영어 단어 추출
updated_jobs = []  # 업데이트된 job 정보를 저장
for line in job_lines:
    try:
        # 줄을 딕셔너리로 변환
        job = eval(line.strip())
        
        # position_id가 None이 아닌 경우에만 처리
        if job.get("position_id") is not None:
            position_id = job["position_id"]
            job_url = f"https://www.wanted.co.kr/wd/{position_id}"

            # 상세 페이지 열기
            driver.get(job_url)

            # 페이지 로드 대기 및 버튼 클릭
            try:
                # 버튼 탐지 및 JavaScript로 클릭
                button = WebDriverWait(driver, 10).until(
                    EC.element_to_be_clickable((By.CLASS_NAME, "Button_Button__root__m1NGq"))
                )
                driver.execute_script("arguments[0].click();", button)

                # 버튼 클릭 후 충분히 대기
                time.sleep(2)  # 동적 데이터 로딩 대기 (필요 시 증가 가능)
            except Exception as e:
                print(f"Error clicking button for {position_id}: {e}")

            # job description 가져오기
            job_description = ""
            try:
                # 모든 wds-wcfcu3 클래스 요소 탐지
                job_description_elements = WebDriverWait(driver, 10).until(
                    EC.presence_of_all_elements_located((By.CLASS_NAME, "wds-wcfcu3"))
                )

                # 각 요소의 하위 span 태그에서 텍스트를 추출
                for element in job_description_elements:
                    spans = element.find_elements(By.TAG_NAME, "span")
                    for span in spans:
                        job_description += span.text + " "
            except Exception as e:
                print(f"Error extracting job description for {position_id}: {e}")

            # 영어 단어 추출
            english_words = extract_english_words(job_description)

            # position_id별 영어 단어 통계
            # position_stats = {}
            for word in english_words:
                word_lower = word.lower()  # 대소문자 구분 없이 처리
                words = re.findall(r"\bgo\b", word_lower)
                if words:
                  print(english_words)
                  with open("urls.txt", "a", encoding="utf-8") as file:
                    file.write(job_url + "\n")
                    print(f"URL 저장 완료: {job_url}")
                # position_stats[word_lower] = position_stats.get(word_lower, 0) + 1
                # agg_data[word_lower] = agg_data.get(word_lower, 0) + 1  # 전체 통계 갱신

            # 직무 정보에 영어 단어 통계 추가
            # job["english_words"] = position_stats
            # updated_jobs.append(job)  # 업데이트된 job 정보 추가

            # print(f"Processed {job['position_name']} ({position_id})")
            # print(position_stats)

    except Exception as e:
        print(f"Error processing line: {line}. Error: {e}")

# 전체 통계를 내림차순으로 정렬
sorted_agg_data = dict(sorted(agg_data.items(), key=lambda item: item[1], reverse=True))

# info_with_english.json 파일에 position_id별 영어 단어 통계 저장
with open("info_with_english.json", "w", encoding="utf-8") as info_file:
    json.dump(updated_jobs, info_file, ensure_ascii=False, indent=4)

# agg.json 파일로 전체 영어 단어 통계 저장
with open("agg.json", "w", encoding="utf-8") as agg_file:
    json.dump(sorted_agg_data, agg_file, ensure_ascii=False, indent=4)

# 브라우저 닫기
driver.quit()