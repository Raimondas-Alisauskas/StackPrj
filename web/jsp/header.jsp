<%@ page import="java.util.ArrayList" %>
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
                <option value="Android">Android</option>
                <option value="iOS">iOS</option>
            </optgroup>
        </select>
    </div>
    <div class="searchField">
        <input type="text" placeholder="Search.." name="search_field">
    </div>
    <div class="searchButton">
        <button type="submit" name="search_button"><i class="fa fa-search"></i></button>
    </div>
</div>
</body>
</html>
