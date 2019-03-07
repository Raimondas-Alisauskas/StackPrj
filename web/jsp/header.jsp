<%@ page import="model.beans.DropdownBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.DTO.TopicDTO" %>
<%@ page import="utils.properties.ConfigurationProperties" %>
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

<div class="card-header">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand " href="<%=request.getContextPath()%>/search">
            <img src="https://cdn.sstatic.net/Sites/stackoverflow/company/img/logos/so/so-logo.svg?v=a010291124bf" height="30" alt="">
        </a>
        <button class="navbar-toggler mb-1" type="button" data-toggle="collapse" data-target="#navbarToggler"
                aria-controls="navbarToggler" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse row" id="navbarToggler">

            <form class="input-group mb-0 " action="search" method="get">
                <%--<div class="row w-100">--%>
                    <div class="col-4">
                        <select class="custom-select" id="lang" name="tagId">
                            <option selected value="">Select a Tag</option>
                            <% for (DropdownBean tag : tagList) { %>
                            <option value="<%=tag.getId()%>" <% if (tagId.equals(tag.getId())){%>
                                    selected<%}%>
                            >
                                <%=tag.getTag()%>
                            </option>
                            <% } %>
                        </select>
                    </div>
                    <div class="col-6">
                        <input type="text" class="form-control " placeholder="Search.." name="search_field"
                               value="<%=searchInput%>">
                    </div>
                    <div class="col-2 d-flex justify-content-end">
                    <button class="btn btn-outline-success ml-auto" type="submit">Search</button>
                    </div>
                <%--</div>--%>

            </form>
        </div>
    </nav>
</div>
</body>
</html>