<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=d, initial-scale=1.0">
    <title>카페 포스기</title>
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        /* 테이블 테두리 및 테두리 중복 제거 */
        table {
            border: 1px solid #000;
            border-collapse: collapse;
        }

        /* 테이블 내부 테두리 및 박스 내부 빈공간 설정 */
        tr, td, th {
            border: 1px solid #000;
            padding: 5px;
        }

        /* 텍스트 입력창 테두리 제거 */
        input {
            border: none;
        }

        
    </style>
    <script>
        // loadHeadler 설정
        // 1. 텍스트 입력창 선택 후 벗어나면 기능 동작
        // 2. 버튼을 클릭 시 기능 동작
        // 3. reset 버튼 클릭 시 기능 동작
        $(loadHeadler);
        function loadHeadler() {
            $('input.count').on("blur", cntBlurHeadler);
            $('[type=button]').on("click", clickEventHeadler);
            $('[type=reset]').on("click", resetEventHeadler);
        }
        
        // 텍스트 입력창 선택 후 벗어날 시 기능이 동작하는 함수
        // $count = 현재 텍스트 입력창 value값 저장
        // $price = 상위 요소 이동 후 해당 요소의 이전 요소로 이동 후 해당 요소의 텍스트값 저장
        // $sum = 상위 요소 이동 후 해당 요소의 다음 요소로 이동 후 해당 요소의 하위 요소로 이동해서 그 요소의 value값을 $count * $price 값으로 변경
        function cntBlurHeadler(event) {
            $count = Number($(this).val());
            $price = $(this).parent().prev().text();
            $sum = $(this).parent().next().children().attr('value', $count * $price);
        }
        
        // 버튼 클릭 시 기능이 동작하는 함수
        // 값을 저장할 변수 2개 설정
        // input.count 클래스의 모든 value값을 $sumCount에 더하기
        // input.sum 클래스의 모든 value값을 $sumPrice에 더하기
        // input.sumCount value에 $sumCount값으로 변경
        // input.sumPrice value에 $sumPrice값으로 변경
        function clickEventHeadler() {
            $sumCount = 0;
            $sumPrice = 0;
            $('input.count').each(function() {
                if(!isNaN($(this).val())) {
                    $sumCount += parseInt($(this).val());
                }
            });
            
            $('input.sum').each(function() {
                if(!isNaN($(this).val())) {
                    $sumPrice += parseInt($(this).val());
                }
            });
            $('input.sumCount').attr('value', $sumCount);
            $('input.sumPrice').attr('value', $sumPrice);
        }

        // reset 시 input 태그의 value값 제거
        function resetEventHeadler() {
            $('input').attr('value', '');
        }
    </script>
</head>
<body>
    <form>
        <table>
            <tr>
                <th>메뉴</th>
                <th>가격</th>
                <th>수량</th>
                <th>합계</th>
            </tr>
            <tr>
                <td>아메리카노</td>
                <td class="price">2500</td>
                <td class="count"><input type="text" class="count"></td>
                <td class="sum"><input type="text" class="sum" readonly></td>
            </tr>
            <tr>
                <td>카페라떼</td>
                <td class="price">3000</td>
                <td class="count"><input type="text" class="count"></td>
                <td class="sum"><input type="text" class="sum" readonly></td>
            </tr>
            <tr>
                <td>홍차라떼</td>
                <td class="price">5000</td>
                <td class="count"><input type="text" class="count"></td>
                <td class="sum"><input type="text" class="sum" readonly></td>
            </tr>
            <tr>
                <th colspan="2">합계</th>
                <td class="sumCount"><input type="text" class="sumCount" readonly></td>
                <td class="sumPrice"><input type="text" class="sumPrice" readonly></td>
            </tr>
            <tr>
                <td colspan="4">
                    <button type="reset">초기화</button>
                    <button type="button" class="btnAdd">계산하기</button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>