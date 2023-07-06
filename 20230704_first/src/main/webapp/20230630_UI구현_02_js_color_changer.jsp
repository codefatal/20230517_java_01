<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Color Changer</title>
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        /* 색깔이 변경될 박스 크기 및 기본 배경색 설정 */
        div.box {
            width: 200px;
            height: 200px;
            border: 1px solid #000;
            background-color: #ccc;
        }
    </style>
    <script>
        // loadHeadler 설정
        // 버튼 클릭, 텍스트 엔터, 드롭박스 선택 시 영향
        $(loadHeadler);
        function loadHeadler() {
            $('button.colorBtn').on("click", btnColor);
            $('input.colorText').on("keypress", textColor);
            $('select.colorDrop').on("change", dropColor);
            
        }

        // 버튼 클릭 시 버튼에 동일한 클래스가 있는 경우 박스 배경색 변경
        function btnColor() {
            if ($(this).hasClass('red')) {
                $('div.box').css('background-color', 'red');
            } else if($(this).hasClass('blue')) {
                $('div.box').css('background-color', 'blue');
            } else if($(this).hasClass('yellow')) {
                $('div.box').css('background-color', 'yellow');
            } else if($(this).hasClass('ccc')) {
                $('div.box').css('background-color', '#ccc');
            }
        }

        // 텍스트에 색상값을 넣는 경우 해당 색상값에 맞는 배경색으로 변경
        // #이 기본적으로 포함되어 있어 색상코드만 넣어주면 됨
        function textColor(k) {
            if(k.keyCode == 13) {
                $('div.box').css('background-color', '#'+$(this).val()); 
            }
        }

        // 드롭박스에 선택한 색상 value 값이 일치하는 색상으로 박스 배경색 변경
        function dropColor() {
            if ($(this).val() == 'red') {
                $('div.box').css('background-color', 'red');
            } else if($(this).val() == 'blue') {
                $('div.box').css('background-color', 'blue');
            } else if($(this).val() == 'orange') {
                $('div.box').css('background-color', 'orange');
            }
        }
    </script>
</head>
<body>
    <div class="box"></div>
    <div class="button">
        <button type="button" class="colorBtn red">Red</button>
        <button type="button" class="colorBtn blue">Blue</button>
        <button type="button" class="colorBtn yellow">Yellow</button>
        <button type="button" class="colorBtn ccc">#ccc</button>
    </div>
    <hr>
    <div class="text">
        <label>Color Code 입력 후 enter : </label><input type="text" class="colorText">
    </div>
    <hr>
    <div class="dropbox">
        <select class="colorDrop">
            <option disabled selected></option>
            <option class="colorDrop" value="red">Red</option>
            <option class="colorDrop" value="blue">Blue</option>
            <option class="colorDrop" value="orange">Orange</option>
        </select>
    </div>
</body>
</html>