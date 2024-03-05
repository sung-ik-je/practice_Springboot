#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// 문자열을 octet string으로 변환하여 반환하는 함수, 일반적으로 ASCII 문자열인 경우 octet string으로 변환했을 때 길이가 같다
// 다른 인코딩 형태인 경우는 문자당 바이트 크기가 달라 변환 시 길이 바뀔 수 있다 
unsigned char* stringToOctetString(const char* str) {
    // 문자열의 길이 계산
    size_t len = strlen(str);

    // octet string을 저장할 배열 동적 할당
    unsigned char* octet_string = (unsigned char*)malloc(len * sizeof(unsigned char));

    // 문자열을 ASCII 값으로 변환하여 octet string에 저장
    for (size_t i = 0; i < len; i++) {
        octet_string[i] = (unsigned char)str[i];
    }

    return octet_string;
}

int main() {
    char str[] = "Hello, world!"; // 입력 받을 문자열
    unsigned char* octet_str = stringToOctetString(str); // octet string으로 변환

    // octet string 출력
    printf("Octet String: ");
    for (size_t i = 0; i < strlen(str); i++) {
        printf("%02X ", octet_str[i]); // 각 octet을 16진수로 출력
    }
    printf("\n");

    // octet string 메모리 해제
    free(octet_str);

    return 0;
}
