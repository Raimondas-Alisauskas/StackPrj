<%--
  Created by IntelliJ IDEA.
  User: Gintare
  Date: 2019-02-19
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="header">
    <div class="drop">
        <select id="lang" name="lang_name">
            <optgroup label="select language">
                <option value="Java">Java</option>
                <option value="php">PHP</option>
                <option value="HTML">HTML</option>
                <option value="CSS">CSS</option>
                <option value="JavaScript">JavaScript</option>
                <option value="Rails">Rails</option>
                <option value="WordPress">WordPress</option>
                <option value="Android">Androild</option>
                <option value="iOS">iOS</option>
            </optgroup>
        </select>
    </div>
    <div class="searchField">
        <form class="example" action="action_page.php">
            <input type="text" placeholder="Search.." name="search">
        </form>
    </div>
    <div class="searchButton">
        <form class="button">
            <button type="submit"><i class="fa fa-search"></i></button>
        </form>
    </div>
</div>
</body>
</html>
