<%@ page import="models.DropdownBin" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<div>
    <form method="get" action="initialPage">
        <button class="searchButton">Home</button>
    </form>
    <form class="header" action="initialPage" method="get">

        <div class="drop">
            <select id="lang" name="tagId">
                <div label="select language">
                    <option disabled selected value>Select a language</option>
                    <% ArrayList<DropdownBin> tagList = (ArrayList) request.getAttribute("tagList");
                        for (DropdownBin tag : tagList) { %>
                    <option value="<%=tag.getId()%>">
                        <%=tag.getTag()%>
                    </option>
                    <% } %>
                </div>
            </select>
        </div>
        <div class="searchField">
            <input type="text" placeholder="Search..." name="search_field">
            <input type="hidden" name="pageNum" value="1">
        </div>
        <button type="submit" class="searchButton"><i class="fa fa-search"></i></button>
    </form>
</div>
</body>
</html>