<%--
  Created by IntelliJ IDEA.
  User: akprz
  Date: 05.08.2020
  Time: 03:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.time.format.DateTimeFormatter" %>

<!DOCTYPE html>
<html>
<head>
    <title>Adverts </title>
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

    <link href="/static/css/bill.css" type="text/css" rel="stylesheet">
    <link href="../../static/css/style.css" type="text/css" rel="stylesheet">

    <link href="/webapp/static/css/comment.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <style>
        div.title {
            text-transform: uppercase;
            font-size: x-large;
        }

        body {
            background-image: url("/static/graphics/korek2.jpg");
        }

        .active-cyan-2 input[type=text]:focus:not([readonly]) {
            border-bottom: 1px solid #4dd0e1;
            box-shadow: 0 1px 0 0 #4dd0e1;
        }

        .active-cyan input[type=text] {
            border-bottom: 1px solid #4dd0e1;
            box-shadow: 0 1px 0 0 #4dd0e1;
        }

        div.advert {
            background-color: lightyellow;
            width: 600px;
            padding: 10px;
            margin: 20px;
        }

        div.buttons {
            padding: 5px;
            margin: 10px;
        }

        h4, h5 {
            color: white;
        }
    </style>
</head>


<body>
<section id="container">

    <header class="header black-bg">
        <jsp:include page="header.jsp"/>
    </header>


    <div id="leftSideOfWeb">
        <jsp:include page="side-menu.jsp"/>
    </div>


    <section id="main-content">
        <section class="wrapper" style="min-height: 800px;">

            &nbsp;


            <div class="row" style="margin-top: 40px; margin-bottom: 10px">
                <div class="col-2"><h4>OGŁOSZENIA</h4></div>
            </div>


            <div class="row">
                <div class="col-6" style="padding-bottom: 20px">

                    <!-- Search form -->
                    <form class="form-inline md-form form-sm active-cyan-2 mt-2">
                        <input class="form-control form-control-sm mr-3 w-75" type="text"
                               placeholder="Szukaj ogłoszenia:"
                               aria-label="Szukaj">
                        <i class="fas fa-search" aria-hidden="false"></i>
                    </form>
                </div>
            </div>

            <c:forEach items="${adverts}" var="advert" varStatus="stat">
                <div class="advert">

                    <table id="adAndCom">
                        <th>
                            <table>
                                <tr>
                                    <td>${advert.user.username}, dodano: ${advert.createdAt.format(DateTimeFormatter
                                            .ofPattern("dd/MM/yyyy  hh:mm a"))}</td>
                                </tr>

                                <td>
                                    <hr>
                                </td>

                                <tr>
                                    <th>
                                        <div class="title">${advert.title}</div>
                                    </th>
                                </tr>


                                <tr>
                                    <td>${advert.description}</td>
                                    <br>
                                </tr>

                            </table>

                            <div class="buttons">
                        <td>
                            <div class="btn-group">
                                <form class="form-inline" method="post" action="/delete-advert">
                                    <button type="submit" class="btn btn-danger">Usuń</button>
                                    <input type="hidden" name="advertId" value="${advert.id}"/>
                                    <sec:csrfInput/>
                                </form>
                                <form class="form-inline" style="margin-left: 1em" method="get"
                                      action="/edit-advert">
                                    <button type="submit" class="btn btn-primary">Edytuj</button>
                                    <input type="hidden" name="advertId" value="${advert.id}"/>
                                    <sec:csrfInput/>
                                </form>
                            </div>
                        </td>
                    </table>


                </div>


                <article class="comment">
                <sec:authorize access="isAuthenticated()">
                    <form class="comment" method="post" action="/add-comment">
                        <input type="text" placeholder="Odpowiedz na ogłoszenie" name="commentText" id="commentText">

                        <button class="btn btn-outline-primary" type="submit">Dodaj</button>
                        <input type="hidden" name="advertId" value="${advert.id}"/>
                        <input type="hidden" name="redirectTo" value="/adverts"/>
                    </form>


                    <c:forEach items="${comments}" var="comment" varStatus="stat">

                        <div class="comment-body">
                            <div class="text">
                                <p>${comment.commentText}</p>
                            </div>
                            <p class="attribution">od <a href="#non">${comment.user}</a>
                                w ${comment.createdAt.format(DateTimeFormatter
                                    .ofPattern("dd/MM/yyyy  hh:mm a"))}</p>
                        </div>
                        </article>

                    </c:forEach>


                </sec:authorize>

            </c:forEach>

            </th>


            </table>
            </div>


            <div class="row" style="margin-center: 40px; margin-bottom: 10px">
                <div class="col-1"></div>
                <div class="col-2"><h5>Dodaj ogłoszenie</h5></div>
                <div class="col-5"></div>
            </div>

            <div class="row">
                <div class="col-2"></div>
                <div class="col-8">

                    <sec:authorize access="isAuthenticated()">
                        <form method="post" action="/add-advert">
                            <div class="form-group">
                                <label for="title" style="color: white">Tytuł:</label> <br>
                                <input type="text" required name="title" id="title">
                            </div>
                            <br>

                            <div class="form-group">
                                <label for="description" style="color: white">Ogłoszenie:</label><br>
                                <textarea name="description" id="description"
                                          class="form-control" maxlength="400"> </textarea>
                            </div>
                            <br>

                            <input type="file" value="Załącz plik"> <br><br>

                            <button class="btn btn-outline-primary" type="reset">Wyczyść dane</button>
                            <button class="btn btn-primary" type="submit">Umieść ogłoszenie</button>
                            <input type="hidden" name="redirectTo" value="/adverts"/>
                        </form>


                    </sec:authorize>


                </div>
                <div class="col-2"></div>
            </div>


        </section>
    </section>


</section>
&nbsp;
<div>

    <footer class="site-footer">
        <jsp:include page="footer.jsp"/>
    </footer>
</div>

</body>
</html>