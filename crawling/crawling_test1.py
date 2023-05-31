from bs4 import BeautifulSoup

html = '''
<html>
    <table border=1> 
        <tr>
            <td> 항목 </td> 
            <td> 2013 </td> 
            <td> 2014 </td> 
            <td> 2015 </td>
        </tr> 
        <tr>
            <td> 매출액 </td> 
            <td> 100 </td> 
            <td> 200 </td>
            <td> 300 </td>
        </tr> 
    </table>
</html> 
'''

html2 = '''
<ul>
    <li> 100 </li> 
    <li> 200 </li>
</ul> 
<ol>
    <li> 300 </li> 
    <li> 400 </li>
</ol>
'''
 
soup = BeautifulSoup(html, 'html5lib') 
soup2 = BeautifulSoup(html2, 'html5lib') 


# td 태그 사용한 구간 중에서 문자열인 경우만 
result = soup.select('td:nth-of-type(1)') 

# td 태그 사용한 구간
result = soup.select('td') 

# ul - li 태그 순차적으로 사용한 구간
# ul - li 계층 구조인 경우
result2 = soup2.select('ul li')


print(result)
print(result2)