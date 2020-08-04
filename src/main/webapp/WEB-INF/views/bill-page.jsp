<%--
  Created by IntelliJ IDEA.
  User: akprz
  Date: 04.08.2020
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.pl.Arkadiusz.FlatApp.model.entities.Bill.Category"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <c:set var="embarkedFund" value="<%=Category.EARMARKED_FUND%>"/>
    <c:set var="repairFund" value="<%=Category.REPAIR_FUND%>"/>
    <c:set var="coAndCW" value="<%=Category.CO_AND_CW_FIXED_FEE%>"/>
    <c:set var="managementCosts" value="<%=Category.MANAGEMENT_COSTS%>"/>
    <c:set var="centralHeating" value="<%=Category.CENTRAL_HEATING%>"/>
    <c:set var="wasteDisposal" value="<%=Category.WASTE_DISPOSAL%>"/>
    <c:set var="waterHeating" value="<%=Category.WATER_HEATING%>"/>
    <c:set var="coldWater" value="<%=Category.COLD_WATER_AND_SEWAGE%>"/>
    <c:set var="energy" value="<%=Category.ENERGY%>"/>
    <title>Bill section</title>
    <link href="/static/css/bill.css" type="text/css" rel="stylesheet">
    <link href="../../static/css/style.css" type="text/css" rel="stylesheet">

    <script>
        window.onload = function () {

            var chart = new CanvasJS.Chart("pieChart", {
                animationEnabled: true,
                title: {
                    text: "Chart of generated costs"
                },
                data: [{
                    type: "pie",
                    startAngle: 240,
                    yValueFormatString: "##0.00\"%\"",
                    indexLabel: "{label} {y}",
                    dataPoints: [
                        {y: ${percentage.get(embarkedFund)}, label: "Earmarked Fund"},
                        {y: ${percentage.get(repairFund)}, label: "Repair Found"},
                        {y: ${percentage.get(coAndCW)}, label: "CO i CW - Fee"},
                        {y: ${percentage.get(managementCosts)}, label: "Management Cost "},
                        {y: ${percentage.get(centralHeating)}, label: "Central Heating"},
                        {y: ${percentage.get(wasteDisposal)}, label: "Waste Disposal"},
                        {y: ${percentage.get(waterHeating)}, label: "Water Heating"},
                        {y: ${percentage.get(coldWater)}, label: "Cold Water and Sewage"},
                        {y: ${percentage.get(energy)}, label: "Energy"}
                    ]
                }]
            });
            var chart2 = new CanvasJS.Chart("lineChart", {
                theme: "light2", // "light1", "light2", "dark1", "dark2"
                animationEnabled: true,
                title: {
                    text: "Trend of your costs"
                },
                axisX: {
                    interval: 1,
                    intervalType: "month",
                    valueFormatString: "MMM"
                },
                axisY: {
                    title: "Price (in PLN)",
                    valueFormatString: "pln#0"
                },
                data: [{
                    type: "line",
                    markerSize: 12,
                    xValueFormatString: "MMM, YYYY",
                    yValueFormatString: "pln###.#",
                    dataPoints: [
                        <c:forEach items="${statistics}" var="stat">
                        {
                            x: new Date(${stat.invoiceDate.year}, ${stat.invoiceDate.month}, ${stat.invoiceDate.day}),
                            y: ${stat.grossAmount},
                            markerType: "triangle",
                            markerColor: "#6B8E23"
                        },
                        </c:forEach>


                    ]
                }]
            });
            chart.render();
            chart2.render();

        }
    </script>

</head>
<body>
<section id="container">
    <header class="header black-bg">
        <jsp:include page="header.jsp"/>
    </header>
    <div>
        <div id="leftSideOfWeb">
            <jsp:include page="side-menu.jsp"/>
        </div>
        <section id="main-content">
            <section class="wrapper">
                <div id="leftbar">
                    <div class="fundbar">
                        <div class="fundname"><h4>Earmarked Fund</h4></div>
                        <div class="fundvalue"><h4>${bills.get(embarkedFund)} pln</h4></div>
                    </div>
                    <div class="fundbar">
                        <div class="fundname"><h4>Repair Found</h4></div>
                        <div class="fundvalue"><h4>${bills.get(repairFund)} pln</h4></div>
                    </div>
                    <div class="fundbar">
                        <div class="fundname"><h4>CO i CW - Fee</h4></div>
                        <div class="fundvalue"><h4>${bills.get(coAndCW)} pln</h4></div>
                    </div>
                    <div class="fundbar">
                        <div class="fundname"><h4>Management Cost</h4></div>
                        <div class="fundvalue"><h4>${bills.get(managementCosts)} pln</h4></div>
                    </div>
                    <div class="fundbar">
                        <div class="fundname"><h4>Central Heating</h4></div>
                        <div class="fundvalue"><h4>${bills.get(centralHeating)} pln</h4></div>
                    </div>
                    <div class="fundbar">
                        <div class="fundname"><h4>Waste Disposal</h4></div>
                        <div class="fundvalue"><h4>${bills.get(wasteDisposal)} pln</h4></div>
                    </div>
                    <div class="fundbar">
                        <div class="fundname"><h4>Water Heating</h4></div>
                        <div class="fundvalue"><h4>${bills.get(waterHeating)} pln</h4></div>
                    </div>
                    <div class="fundbar">
                        <div class="fundname"><h4>Cold Water and Sewage</h4></div>
                        <div class="fundvalue"><h4>${bills.get(coldWater)} pln</h4></div>
                    </div>
                    <div class="fundbar">
                        <div class="fundname"><h4>Energy</h4></div>
                        <div class="fundvalue"><h4>${bills.get(energy)} pln</h4></div>
                    </div>
                </div>
                <div id="rightbar">
                    <div id="topbar">
                        <div id="pieChart">
                            <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
                        </div>
                        <div id="menu">
                            <fieldset style="margin:15px; height:45%;">
                                <legend style="text-align:center">THE TOTAL AMOUNT TO PAY:</legend>
                                <div id="sum"> ${billsToPay} pln</div>
                            </fieldset>
                            <button id="pay" type="submit">Pay</button>
                        </div>
                    </div>
                    <div id="stat">
                        <div id="slicer">
                            <div class="button"><a href="/bills/energy" classs="media">Energy</a></div>
                            <div class="button"><a href="/bills/water" classs="media">Water</a></div>
                            <div class="button"><a href="/bills/heating" classs="media">Heating</a></div>
                        </div>
                        <div id="lineChart">
                            <%--                <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>--%>
                        </div>
                    </div>
                </div>
            </section>
        </section>
    </div>
    <footer class="site-footer">
        <jsp:include page="footer.jsp"/>
    </footer>
</section>
</body>
</html>
