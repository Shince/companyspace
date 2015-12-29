<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<a class="navbar-brand" href="<c:url value="/" />">Love Match</a>
		</div>

		<form:form class="navbar-form navbar-left" role="search"
			action="#" method="post">
			<div class="form-group">
				<div class="controls">
					<input type="text" class="form-control" name="username">
				</div>
			</div>
			<button type="submit" class="btn btn-default">Search</button>
		</form:form>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">More <span
						class="glyphicon glyphicon-menu-down"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Login</a></li>
						<li><a href="#">Register</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</nav>