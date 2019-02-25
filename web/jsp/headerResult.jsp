<%@ page import="models.DocTagDAL" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<div class="header">
    <div class="searchWrapper">
    <div class="drop">
        <select id="lang" name="lang_name" class="drop">
            <%--<optgroup label="select language">--%>
                <%--<% ArrayList<DocTagDAL> tagList = (ArrayList) request.getAttribute("tagList");--%>
                    <%--for (DocTagDAL tag : tagList) { %>--%>
                <%--<option value="<%=tag.getTag()%>"><%=tag.getTag()%>--%>
                <%--</option>--%>

                <%--<% } %>--%>


            <%--</optgroup>--%>
        </select>
    </div>
    <div class="searchField">
        <input type="text" placeholder="Search.." name="search_field" class="searchField">
    </div>

        <button type="submit" name="search_button" class="searchButton"> Search <i class="fa fa-search"></i></button>
    </div>
</div>
</body>
</html>