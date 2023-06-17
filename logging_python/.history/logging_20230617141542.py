import logging



logger = logging.getLogger()
logger.setLevel(logging.INFO)
formatter = logging.Formatter(u'%(asctime)s [%(levelname)8s] %(message)s')
file_handler = logging.FileHandler('LogPractice.log', encoding='utf-8')
file_handler.setFormatter(formatter)
logger.addHandler(file_handler)


logger.info('S 기존 테이블 삭제 완료\n')









