<%@ page import="models.DropdownBin" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
    </head>
    <body>

        <div class="header">
            <form action="search" method="get">
            <div class="drop">
                <select id="lang" name="lang_name">
                    <div label="select language">
                        <% ArrayList<DropdownBin> tagList = (ArrayList) request.getAttribute("tagList");
                            for (DropdownBin tag : tagList) { %>
                        <option value="<%=tag.getTag()%>"><%=tag.getTag()%>
                        </option>
                        <% } %>
                    </div>
                </select>
            </div>
            <div class="searchField">
                <input type="text" placeholder="Search.." name="search_field">
                <input type="hidden"  name="pageNum" value="1">
            </div>
            <div class="searchButton">
                <button type="submit"><i class="fa fa-search"></i></button>
            </div>
                </form>
        </div>
    </body>
</html>