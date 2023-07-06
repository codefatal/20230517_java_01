<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CheckAll</title>
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        .checkboxs {
            display: flex;
            justify-content: flex-start;
        }
        .box {
            padding: 5px;
        }
    </style>
</head>
<body>
    <div>
        <label for="allCheck">ì ì²´ì í : </label>
        <input type="checkbox" id="allCheck">
        <label for="revCheck">ë°ëì í : </label>
        <input type="checkbox" id="revCheck">
    </div>
    <hr>
    <div class="checkboxs">
        <!-- $checkboxs -->
    </div>
    <script>
        const itemCnt = 10;
        var $checkboxs = "";
        for(i=1; i<=itemCnt; i++) {
            $checkboxs += 
            `<div class="box">
                <label for="id-${i}">id-${i} : </label>
                <input type="checkbox" id="id-"${i}" class="checkitem">
            </div>`;
        }
        $('.checkboxs').append($checkboxs);


        // ì ì²´ì í ë²í¼ í´ë¦­ ì ê¸°ë¥
        $('input#allCheck').on("click", allCheck);
        // ë°ëì í ë²í¼ í´ë¦­ ì ê¸°ë¥
        $('input#revCheck').on("click", revCheck);
        // id ì²´í¬ë°ì¤ í´ë¦­ ì ê¸°ë¥
        $('.checkitem').on("click", itemCheck);

        // checkitem í´ëì¤ì ëª¨ë  ë²í¼ ì²´í¬
        function allCheck(e) {
            $('.checkitem').prop("checked", $(this).prop("checked"));
        }

        // ì ì²´ì í ë²í¼ì´ ìë checkitem í´ëì¤ì ëª¨ë  ë²í¼ì í´ë¦­ ì ì ì²´ì í ë²í¼ ì²´í¬
        function itemCheck(e) {
            if(itemCnt == $('.checkitem:checked').length) {
                $("#allCheck").prop("checked", true);
            } else {
                $("#allCheck").prop("checked", false);
            }
        }

        // ë°ëì í ë²í¼ í´ë¦­ ì ì²´í¬ ë°ëë¡ ì¤ì 
        function revCheck(e) {
            $('.checkitem').prop("checked", function(idx, val) { return !val });
        }
    </script>
</body>
</html>