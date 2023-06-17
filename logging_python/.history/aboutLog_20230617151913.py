import logging


# logging 객체 선언
logger = logging.getLogger()


'''
log로 기록 될 레벨 선정
    ex) 여기선 INFO 레벨 이상부터 모든 LOG가 기록된다
'''
logger.setLevel(logging.INFO)

formatter = logging.Formatter(u'%(asctime)s [%(levelname)s] %(message)s')
file_handler = logging.FileHandler('LogPractice.log', encoding='utf-8')
file_handler.setFormatter(formatter)
logger.addHandler(file_handler)


logger.info('logging 입력 test\n')









