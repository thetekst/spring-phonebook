<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <spring:url value="/resources/lib/bootstrap/css/bootstrap.min.css" var="bootstrapCss"/>
    <spring:url value="/resources/lib/jquery/jquery.min.js" var="jquery"/>
    <spring:url value="/resources/lib/bootstrap/js/bootstrap.min.js" var="bootstrapJs"/>
    <spring:url value="/resources/lib/script.js" var="scriptJs"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <title>Home</title>
</head>
<body>
<div class="container">
    <div class="row"><%@include file='sidebar.jsp'%></div>
    <div class="row">