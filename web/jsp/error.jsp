<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/images/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
<div class="jumbotron d-flex justify-content-center">
    <div class="card w-75">
        <jsp:include page="header.jsp"/>
        <h1  id="error-mes">Error have been occured</h1>
        <h2 id="error-mes"> Error code is: <p id="error-code"><%= request.getAttribute("javax.servlet.error.status_code")%></p></h2>
            <%switch ((request.getAttribute("javax.servlet.error.status_code")).toString()) {
                case "400":
        %> <h2 id="error-mes"> Bad request error, go back and try again </h2><%
                break;
            case "403":
        %> <h2 id="error-mes"> This action is forbidden, please go back and try again</h2><%
                break;
            case "404":
        %><h2 id="error-mes"> Page not found, go back and try again </h2><%
                break;
            case "405":
        %><h2 id="error-mes"> This function is not allowed, go back and try again</h2><%
                break;
            case "408":
        %><h2 id="error-mes"> Request timeout, server haven't got information about a resource</h2><%
                break;
            case "500":
        %><h2 id="error-mes"> Server error, that is our fault</h2>
            <h2 id="error-mes"> We are very sorry, please go back and try again </h2><%
                    break;
                case "501":
            %> <h2 id="error-mes">Function not implemented yet, we are working on it </h2>
            <h2 id="error-mes"> We are very sorry, please go back and try again </h2><%
            break;
        case "503":
            %> <h2 id="error-mes"> Service not available at this moment</h2>
            <h2 id="error-mes"> We are very sorry, please go back and try again </h2><%
            break;
        default:
            break;
            }
    %>
        <div>
            <button type="button" class="btn btn-primary" id="back" onclick="history.back()">Back
            </button>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>