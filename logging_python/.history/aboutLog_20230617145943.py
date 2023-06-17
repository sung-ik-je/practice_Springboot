import logging



logger = logging.getLogger()

logger.setLevel(logging.INFO)
formatter = logging.Formatter(u'%(asctime)s [%(levelname)s] %(message)s')
file_handler = logging.FileHandler('LogPractice.log', encoding='utf-8')
file_handler.setFormatter(formatter)
logger.addHandler(file_handler)


logger.info('logging 입력 test\n')









