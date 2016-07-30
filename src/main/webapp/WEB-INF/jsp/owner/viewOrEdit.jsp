<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="mode" scope="request" type="tk.puncha.controllers.ControllerBase.FormMode"/>
<jsp:useBean id="owner" scope="request" type="tk.puncha.models.Owner"/>
<!DOCTYPE html>

<html lang="en">
<jsp:include page="../common/header.jsp"/>
<body>
<jsp:include page="../common/nav.jsp"/>

<div class="container">

  <c:if test="${mode == 'Readonly'}" var="viewOnly"/>

  <form:form modelAttribute="owner" cssClass="form-horizontal" action="/owners/new" method="post">
    <div class="form-group">
      <form:label path="firstName" cssClass="col-xs-2 control-label">First name</form:label>
      <div class="col-xs-5">
        <form:input path="firstName" cssClass="col-sm-10 form-control" readonly="${viewOnly}"/>
      </div>
      <form:errors path="firstName"/>
    </div>

    <div class="form-group">
      <form:label path="lastName" cssClass="col-xs-2 control-label">Last name</form:label>
      <div class="col-xs-5">
        <form:input path="lastName" cssClass="col-sm-10 form-control" readonly="${viewOnly}"/>
      </div>
      <form:errors path="lastName"/>
    </div>

    <div class="form-group">
      <form:label path="address" cssClass="col-xs-2 control-label">Address</form:label>
      <div class="col-xs-5">
        <form:input path="address" cssClass="col-sm-10 form-control" readonly="${viewOnly}"/>
      </div>
      <form:errors path="address"/>
    </div>

    <div class="form-group">
      <form:label path="city" cssClass="col-xs-2 control-label">City</form:label>
      <div class="col-xs-5">
        <form:input path="city" cssClass="col-sm-10 form-control" readonly="${viewOnly}"/>
      </div>
      <form:errors path="city"/>
    </div>


    <div class="form-group">
      <form:label path="telephone" cssClass="col-xs-2 control-label">Telephone</form:label>
      <div class="col-xs-5">
        <form:input path="telephone" cssClass="col-sm-10 form-control" readonly="${viewOnly}"/>
      </div>
      <form:errors path="telephone"/>
    </div>

    <c:if test="${!viewOnly}">
      <form:hidden path="id"/>

      <div>
        <label class="label label-danger">Errors:</label>
        <br/>
        <ul><form:errors path="*"/></ul>
      </div>

      <div class="form-group row">
        <div class="col-xs-offset-2 col-xs-3">
          <button type="submit" class="btn btn-primary">Submit</button>
        </div>
        <div class="col-xs-3">
          <button type="reset" class="btn btn-primary">Reset</button>
        </div>
      </div>
    </c:if>
  </form:form>

  <c:if test="${viewOnly}">
    <div>
      <hr/>
      <label class="col-xs-2 control-label">Pets</label>
      <ul>
        <c:forEach var="pet" items="${owner.pets}">
          <li class="badge">${pet.name}</li>
        </c:forEach>
      </ul>
    </div>
  </c:if>

</div>
<jsp:include page="../common/footer.jsp"/>
<jsp:include page="../common/scripts.jsp"/>
</body>
</html>