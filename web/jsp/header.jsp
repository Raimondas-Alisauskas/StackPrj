<%@ page import="models.DropdownBin" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.TopicResults" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        TopicResults topicResults = (TopicResults) request.getAttribute("topicResults");
        int tagId = topicResults.getTagId();
        String searchInput = topicResults.getSearchInput();
        ArrayList<DropdownBin> tagList = (ArrayList) request.getAttribute("tagList");


    %>
</head>
<body>

<div>
    <form class="header" action="search" method="get">
        <div class="drop">
            <select id="lang" name="tagId">
                <div label="select language">
                    <option value="">--Choose the Tag--</option>
                    <% for (DropdownBin tag : tagList) { %>
                        <option value="<%=tag.getId()%>" <% if (tag.getId() == tagId){%>
                                selected<%}%>
                        >
                            <%=tag.getTag()%>
                        </option>
                    <% } %>
                </div>
            </select>
        </div>
        <div class="searchField">
            <input type="text" placeholder="Search.." name="search_field" value="<%=searchInput%>">
            <%--<input type="hidden" name="pageNum" value="1">--%>
        </div>
        <button type="submit" class="searchButton"><i class="fa fa-search"></i></button>
    </form>
</div>
</body>
</html>