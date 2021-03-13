<%@ page import="com.example.OSFInalProject.BestFit.BestFit" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.OSFInalProject.BestFit.Memory" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.OSFInalProject.BestFit.Job" %><%--
  Created by IntelliJ IDEA.
  User: Илон Маск
  Date: 13.03.2021
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table.blueTable {
            border: 1px solid #1C6EA4;
            background-color: #EEEEEE;
            width: 100%;
            text-align: left;
            border-collapse: collapse;
        }
        table.blueTable td, table.blueTable th {
            border: 1px solid #AAAAAA;
            padding: 3px 2px;
        }
        table.blueTable tbody td {
            font-size: 13px;
        }
        table.blueTable tr:nth-child(even) {
            background: #D0E4F5;
        }
        table.blueTable thead {
            background: #1C6EA4;
            background: -moz-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);
            background: -webkit-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);
            background: linear-gradient(to bottom, #5592bb 0%, #327cad 66%, #1C6EA4 100%);
            border-bottom: 2px solid #444444;
        }
        table.blueTable thead th {
            font-size: 15px;
            font-weight: bold;
            color: #FFFFFF;
            border-left: 2px solid #D0E4F5;
        }
        table.blueTable thead th:first-child {
            border-left: none;
        }

        table.blueTable tfoot td {
            font-size: 14px;
        }
        table.blueTable tfoot .links {
            text-align: right;
        }
        table.blueTable tfoot .links a{
            display: inline-block;
            background: #1C6EA4;
            color: #FFFFFF;
            padding: 2px 8px;
            border-radius: 5px;
        }
        table.topazCells {
            border: 4px solid #555555;
            background-color: #555555;
            width: 400px;
            text-align: center;
            border-collapse: collapse;
        }
        table.topazCells td, table.topazCells th {
            border: 1px solid #555555;
            padding: 4px 7px;
        }
        table.topazCells tbody td {
            font-size: 13px;
            font-weight: bold;
            color: #FFFFFF;
        }
        table.topazCells tr:nth-child(even) {
            background: #A43152;
        }
        table.topazCells td:nth-child(even) {
            background: #A43152;
        }
        table.topazCells tfoot td {
            font-size: 13px;
        }
        table.topazCells tfoot .links {
            text-align: right;
        }
        table.topazCells tfoot .links a{
            display: inline-block;
            background: #FFFFFF;
            color: #A43152;
            padding: 2px 8px;
            border-radius: 5px;
        }
        table.steelBlueCols {
            border: 4px solid #555555;
            background-color: #555555;
            width: 400px;
            text-align: center;
            border-collapse: collapse;
        }
        table.steelBlueCols td, table.steelBlueCols th {
            border: 1px solid #555555;
            padding: 5px 10px;
        }
        table.steelBlueCols tbody td {
            font-size: 12px;
            font-weight: bold;
            color: #FFFFFF;
        }
        table.steelBlueCols td:nth-child(even) {
            background: #398AA4;
        }
        table.steelBlueCols thead {
            background: #398AA4;
            border-bottom: 10px solid #398AA4;
        }
        table.steelBlueCols thead th {
            font-size: 15px;
            font-weight: bold;
            color: #FFFFFF;
            text-align: left;
            border-left: 2px solid #398AA4;
        }
        table.steelBlueCols thead th:first-child {
            border-left: none;
        }

        table.steelBlueCols tfoot td {
            font-size: 13px;
        }
        table.steelBlueCols tfoot .links {
            text-align: right;
        }
        table.steelBlueCols tfoot .links a{
            display: inline-block;
            background: #FFFFFF;
            color: #398AA4;
            padding: 2px 8px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<%List<BestFit> bestFitList = (List<BestFit>) request.getAttribute("bestFits");
    String status = null;
%>

<table class="blueTable">
    <thead>
    <tr>
        <th>MemoryID</th>
        <th>MemorySize</th>
        <th>JobNum</th>
        <th>Status</th>
        <th>internalFragmentation</th>
    </tr>
    </thead>

    <tbody>
    <%   for (BestFit bestFit : bestFitList){
    if (bestFit.isStatus() == false)
         status = "busy";
    else
        status ="free";
    %>
    <tr>
        <td><%=bestFit.getMemoryid()%></td>
        <td><%=bestFit.getMemorySize()%></td>
        <td><%=bestFit.getJobNumber()%></td>
        <td><%=status%></td>
        <td><%=bestFit.getInternalFragmentation()%></td>
    </tr>
    <%
    }
    %>
    <%
     int Totalmemory = (int) request.getAttribute("memory");
     int jibSize = (int) request.getAttribute("jobsize");
     int II = (int) request.getAttribute("II");
    %>
    <tr>
        <td>Total memory :<%=Totalmemory%></td>
        <td>Total jobSize: <%=jibSize%></td>
        <td>All InternalFragmentation<%=II%></td>
    </tr>
    </tbody>
</table>
<hr>
    <%
        List<Memory> memoryList = (List<Memory>) request.getAttribute("memoryList");
        List<Job> jobList = (List<Job>) request.getAttribute("jobList");
    %>
<table class="topazCells">
    <tbody>
    <tr>
        <td>JobNum</td>
        <td>memoryRequested</td>
    </tr>
    <%   for (Job job : jobList){  %>
    <tr>
        <td><%=job.getJobNumber()%></td>
        <td><%=job.getMemoryRequested()%></td>
    </tr>
<%
        }
        %>
    </tbody>
</table>
<hr>

<table class="steelBlueCols">
    <thead>
    <tr>
        <th>id</th>
        <th>MemorySize</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
    <%   for (Memory memory : memoryList){
        if (memory.isStatus() == false)
        status = "busy";
        else
        status ="free"; %>
    <tr>
        <td><%=memory.getId()%></td>
        <td><%=memory.getMemorySize()%></td>
        <td><%=status%></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
