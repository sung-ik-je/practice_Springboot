import logging



logger2 = logging.getLogger()

logger.setLevel(logging.INFO)
formatter = logging.Formatter(u'%(asctime)s [%(levelname)8s] %(message)s')
file_handler = logging.FileHandler('LogPractice.log', encoding='utf-8')
file_handler.setFormatter(formatter)
logger.addHandler(file_handler)


logger.info('logging 입력 test\n')









