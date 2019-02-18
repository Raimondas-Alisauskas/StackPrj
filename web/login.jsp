<%--suppress ReferencesToClassesFromDefaultPackagesInJSPFile --%>
<%@ page pageEncoding="UTF-8" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%@ page import="models.Person" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inform</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link href='http://fonts.googleapis.com/css?family=Nunito:400,300'
          rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="main.css">
</head>
<body>

<jsp:useBean id="myPerson" class="models.Person"
             scope="request"></jsp:useBean>

<%
    Person person = (Person) request.getAttribute("myPerson");
%>

<form>

    <h1>Inform</h1>

    <fieldset>
        <legend>
            <span class="number">1</span>Your basic info
        </legend>
        <label for="name">Name:</label> <input type="text" id="name"
                                               name="user_name"
                                               value="<jsp:getProperty property="name" name="myPerson"/>">

        <label for="mail">Email:</label> <input type="email" id="mail"
                                                name="user_email"
                                                value=" <jsp:getProperty property="email" name="myPerson"/>">

        <label for="password">Password:</label> <input type="text"
                                                       id="password" name="user_password"
                                                       value="<jsp:getProperty property="password" name="myPerson"/>">

        <label>Age:</label> <input type="email" id="mail2" name="mail"
                                   value="${myPerson['age']}">
    </fieldset>

    <fieldset>
        <legend>
            <span class="number">2</span>Your profile
        </legend>
        <label for="bio">Biography:</label>
        <textarea id="bio" name="user_bio"> ${myPerson["bio"]}</textarea>
    </fieldset>
    <fieldset>
        <label for="job">Job Role:</label> <input type="email" id="mail3"
                                                  name="mail2"
                                                  value="<jsp:getProperty property="job" name="myPerson"/>"> <label>Interests:</label>
        <input type="email" id="mail4" name="mail3"
               value=" <%=person.getInterest()%>">
    </fieldset>

</form>

</body>
</html>