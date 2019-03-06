<%@ page import="model.beans.DropdownBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.DTO.TopicDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        TopicDTO topicDTO = (TopicDTO) request.getAttribute("topicDTO");
        String tagId = "";
        String searchInput = "";
        if (topicDTO != null){
            tagId = topicDTO.getTagId();
            searchInput = topicDTO.getSearchInput();
        };

        ArrayList<DropdownBean> tagList = (ArrayList) session.getAttribute("tagList");
    %>
</head>
<body>

<div>
    <form method="get" action="search">
        <button class="searchButton">Home</button>
    </form>
    <form class="header" action="search" method="get">
        <div class="drop">
            <select id="lang" name="tagId">
                <div class="down">
                    <option value="">--Select a Tag--</option>
                    <% for (DropdownBean tag : tagList) { %>
                    <option value="<%=tag.getId()%>" <% if (tagId.equals(tag.getId())){%>
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
        </div>
        <button type="submit" class="searchButton"><i class="fa fa-search"></i></button>
    </form>
</div>
</body>
</html>