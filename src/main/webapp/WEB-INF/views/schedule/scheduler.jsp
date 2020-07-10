<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/project/resources/css/scheduler.css" rel="stylesheet" id="bootstrap-css">
<h1 style="text-align: center">- 근 무 관 리 -</h1>

<div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-8"><h2><b>일 간 근 무 표</b></h2></div>
                    <div class="col-sm-5"><input type="date" id="checkdate" name="checkdate"></div>
                    <div class="col-sm-4">
                        <button type="button" class="btn btn-info add-new"><i class="fa fa-plus"></i> Add New</button>
                    </div>
                </div>
            </div>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>이름</th>
                        <th>부서</th>
                        <th>파트</th>
                        <th>시작시간</th>
                        <th>종료시간</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Subhash</td>
                        <td>Administration</td>
                        <td>88***88***</td>
                        <td>15:30</td>
                        <td>20:30</td>
                        <td>
                            <a href="#" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons"></i></a>
                            <a href="#" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons"></i></a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    
