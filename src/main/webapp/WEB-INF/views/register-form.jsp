<%--
  Created by IntelliJ IDEA.
  User: akprz
  Date: 03.08.2020
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
            integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
            integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="row" style="margin-top: 40px">
        <div class="col-1"></div>
        <div class="col-10" style="padding-bottom: 20px"><h2>Registry</h2></div>
        <div class="col-1"></div>
    </div>
    <div class="row">
        <div class="col-1"></div>
        <div class="col-6">
            <f:form modelAttribute="UserRegistration" action="/register" method="post">
                <div class="form-group">
                    <div>
                        <f:label path="username">Username*</f:label>
                    </div>
                    <div>
                        <f:input path="username" type="text" value="${UserRegistration.username}" id="username"
                                 cssClass="form-control" cssErrorClass="error-message" required="true"/>
                    </div>
                    <div>
                        <f:errors cssClass="error-message" path="username"/>
                    </div>
                </div>

                <div class="form-group">
                    <div>
                        <f:label path="firstName">First name*</f:label>
                    </div>
                    <div>
                        <f:input path="firstName" type="text" value="${UserRegistration.firstName}" id="firstName"
                                 cssClass="form-control" cssErrorClass="error-message" required="true"/>
                    </div>
                    <div>
                        <f:errors cssClass="error-message" path="firstName"/>
                    </div>
                </div>
                <div class="form-group">
                    <div>
                        <f:label path="lastName">Last name*</f:label>
                    </div>
                    <div>
                        <f:input path="lastName" type="text" value="${UserRegistration.lastName}" id="lastName"
                                 cssClass="form-control" cssErrorClass="error-message" required="true"/>
                    </div>
                    <div>
                        <f:errors cssClass="error-message" path="lastName"/>
                    </div>
                </div>

                <div class="form-group">
                    <div>
                        <f:label path="password">Password*</f:label>
                    </div>
                    <div>
                        <f:input path="password" type="text" placeholder="Enter your username" id="password"
                                 pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at
                least one number and one uppercase and lowercase letter, and at least 8 or more characters"
                                 cssClass="form-control" cssErrorClass="error-message" required="true"/>
                    </div>
                    <div>
                        <f:errors cssClass="error-message" path="password"/>
                    </div>
                </div>

                <div class="form-group">
                    <div>
                        <f:label path="email">E-mail*</f:label>
                    </div>
                    <div>
                        <f:input path="email" type="text" placeholder="sample@service.surfix" id="email"
                                 pattern="^(.+)@(.+)$"
                                 cssClass="form-control" cssErrorClass="error-message" required="true"/>
                    </div>
                    <div>
                        <f:errors cssClass="error-message" path="email"/>
                    </div>
                </div>

                <div class="form-group">
                    <div>
                        <f:label path="flatNumber">E-mail*</f:label>
                    </div>
                    <div>
                        <f:select path="flatNumber" required="true">
                        <f: option value="-" label="--Please Select"/>
                        <f: options items="${flatNumbers}" itemValue="number" itemLabel="flatNumbers"/>
                    </div>
                    </f:select>
                    <div>
                        <f:errors cssClass="error-message" path="email"/>
                    </div>
                    <button class="btn btn-primary" type="submit">Register</button>
                    <button class="btn btn-secondary" type="reset">Clean</button>
                </div>

            </f:form>


<%--            <form method="post" action="/register">--%>
            <%--                <div class="form-group">--%>
            <%--                    <label for="username">Username</label>--%>
            <%--                    <input type="text" required name="username" id="username" class="form-control"--%>
            <%--                           placeholder="Enter your username"/>--%>
            <%--                </div>--%>
            <%--                <div class="form-group">--%>
            <%--                    <label for="firstName">First name</label>--%>
            <%--                    <input type="text" required name="firstName" id="firstName" class="form-control"--%>
            <%--                           placeholder="Enter your first name"/>--%>
            <%--                </div>--%>
            <%--                <div class="form-group">--%>
            <%--                    <label for="lastName">Last name</label>--%>
            <%--                    <input type="text" required name="lastName" id="lastName" class="form-control"--%>
            <%--                           placeholder="Enter your last name"/>--%>
            <%--                </div>--%>

            <%--                <div class="form-group">--%>
            <%--                    <label for="password">Password</label>--%>
            <%--                    <input type="password" id="password" name="password"--%>
            <%--                    &lt;%&ndash;                           pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" &ndash;%&gt;--%>
            <%--                           class="form-control" title="Must contain at--%>
            <%--                least one number and one uppercase and lowercase letter, and at least 8 or more characters" required--%>
            <%--                           placeholder="Enter your password">--%>
            <%--                </div>--%>

            <%--                <div class="form-group">--%>
            <%--                    <label for="email">E-mail</label>--%>
            <%--                    <input type="email" required name="email" id="email" class="form-control"--%>
            <%--                           placeholder="Enter your e-mail"/>--%>
            <%--                </div>--%>
            <%--                <div><label for="flatNumber">Flat number:</label>--%>
            <%--                    <select name="flatNumber" id="flatNumber" required>--%>
            <%--                        <option value="-" selected> --Choose flat number--</option>--%>
            <%--                        <c:forEach items="${flatNumbers}" var="flatNumber">--%>
            <%--                            <option value="${flatNumber}">${flatNumber}</option>--%>
            <%--                        </c:forEach>--%>
            <%--                    </select></div>--%>
            <%--                <button class="btn btn-primary" type="submit">Register</button>--%>
            <%--                <button class="btn btn-secondary" type="reset">Clean</button>--%>
            <%--                <sec:csrfInput/>--%>
            <%--            </form>--%>
        </div>
        <div class="col-5"></div>
    </div>
</div>
</body>
</html>
