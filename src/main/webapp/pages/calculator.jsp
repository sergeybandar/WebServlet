<%--
  Created by IntelliJ IDEA.
  User: Xiaomi
  Date: 19.01.2021
  Time: 1:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        table td{
            width: 24%;
        }
        table tr{
            vertical-align: middle;
        }
        table div{
            background: #f1f3f4;
            color: #202124;
            border: 1px solid #f1f3f4;
            border-radius: 4px;
            width: 98%;
            height: 48px;
            cursor: pointer;
            font-family: arial,sans-serif;
            text-align: center;
            vertical-align: middle;

        }
    </style>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div style="width: 60%; display: block; margin-left: auto; margin-right: auto">
    <form class="row g-3" action="/calc" method="post"
          style="width: 70%; display: block; margin-left: auto; margin-right: auto">

        <div class="form-floating">
            <input type="text" class="form-control" id="floatingPassword" name="str" value="${requestScope.initialData}" readonly>
            <label for="floatingPassword">Mathematical expression</label>
        </div>
        <div class="form-floating">
            <input type="text" class="form-control" value="${requestScope.result}" readonly>
            <label for="floatingPassword">Result</label>
        </div>
        <table>
            <tr>
                <td><div>7</div></td>
                <td><div>8</div></td>
                <td><div>9</div></td>
                <td><div>/</div></td>
            </tr>
            <tr>
                <td><div>4</div></td>
                <td><div>5</div></td>
                <td><div>6</div></td>
                <td><div>*</div></td>
            </tr>
            <tr>
                <td><div>1</div></td>
                <td><div>2</div></td>
                <td><div>3</div></td>
                <td><div>-</div></td>
            </tr>
            <tr>
                <td><div>.</div></td>
                <td><div>0</div></td>
                <td><div><</div></td>
                <td><div>+</div></td>
            </tr>
            <tr>
                <td><div>AC</div></td>
                <td></td>
                <td></td>
                <td><button type="submit" class="btn btn-primary" style="display:block; width: 100%; height: 100%">=</button></td>
            </tr>
        </table>
<%--        <div class="col-12">--%>
<%--            <button type="submit" class="btn btn-primary" style="display:block; margin-left: auto">Sign in</button>--%>
<%--        </div>--%>
    </form>
    <h2>${requestScope.result}</h2>
</div>
<script>
let arrTd=document.querySelectorAll("tr td");
console.log(arrTd.length);
let mathematicalInput=document.querySelector('form div #floatingPassword');
mathematicalInput.addEventListener('click',()=>{

})
for(let i=0; i<arrTd.length; i++){
    console.log(i+" "+arrTd[i].firstChild.innerText);
    if(i==14){
        arrTd[i].addEventListener('click',()=>{
            if(mathematicalInput.value.length>0){
            mathematicalInput.value=mathematicalInput.value.slice(0,mathematicalInput.value.length-1);
            }
        })
        continue;
    }
    if(i==16){
        arrTd[i].addEventListener('click',()=>{
            if(mathematicalInput.value.length>0){
                mathematicalInput.value="";
            }
        })
        continue;
    }
    if(i==17){
        continue;
    }
    arrTd[i].addEventListener('click',()=>{

       mathematicalInput.value=""+mathematicalInput.value+""+arrTd[i].firstChild.innerText;

    })

}
</script>
</body>
</html>
