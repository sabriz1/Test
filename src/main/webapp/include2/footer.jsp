<%@page import="beans.Section"%>
<footer class="footer pt-3  ">
	<div class="container-fluid">

		<link href="include2/style.css" rel="stylesheet" type="text/css" />
		<link href="include2/csslocal.css" rel="stylesheet" type="text/css" />
		
		<form action="PlaceController" method="GET">
		
			<%@page import="service.PlaceService"%>
			<%@page import="service.SectionService"%>
			<%@page import="beans.Place"%>
			<%@page import="beans.Section"%>
			<input id="id" type="hidden" name="id" value="<%= request.getParameter("id")== null ? "": request.getParameter("id") %>" required="" style="width: 135px;" />
			<fieldset style="width: 588px;">
				<legend>Places</legend>
				<table border="0">
					<tr>
						<td>numeroPla</td>
						<td><input id="numeroPla" type="text" name="numeroPla" value="<%= request.getParameter("numeroPla")== null ? "": request.getParameter("numeroPla") %>" required="" style="width: 135px;" /></td>
						<td style="width: 307px;">*</td>
					</tr>
					<tr>
						<td style="width: 76px;">etat</td>
						<td style="width: 737px;">
							<form action="some.jsp">
								<input id="etat" type="text" name="etat" value="<%= request.getParameter("etat")== null ? "": request.getParameter("etat") %>" required="" style="width: 134px; height: 33px;" /></td>
								<tr>
						<td>Section</td>
						<td><select id="Section" name="Section">
								<%
								SectionService ss = new SectionService();
								for (Section s : ss.findAll()) {
								%>
								<option value="<%=s.getId()%>"><%=s%></option>
								<%
								}
								%>
						</select></td>
						<td style="width: 307px;">*</td>
					</tr>
								<tr>
									<td></td>
									<td><input id="add" type="submit" value="Envoyer" /></td>
								</tr>
							</form>
						
					</tr>

				</table>
			</fieldset>


			<fieldset>
				<legend>Liste des Places</legend>

				<table border="1" class="tab" style="width: 501px;">
					<thead>
						<tr>
							<th>Id</th>
							<th>numeroPla <br>
							<th>etat</th>
							<th>Section</th>
							<th>Supprimer</th>
							<th>Modifier</th>
						</tr>
					</thead>
					<tbody id="content">
						<%
						PlaceService ps = new PlaceService();
						for (Place p : ps.findAll()) {
						%>
						<tr>
							<td><%=p.getId()%></td>
							<td><%=p.getNumeroPla()%></td>
							<td><%=p.getEtat()%></td>
							<td><%=p.getSection().getId()%></td>
							
							<td><a href="PlaceController?id=<%=p.getId()%>&op=delete">Supprimer
							</a></td>
							<td><a href="PlaceController?id=<%=p.getId()%>&op=update">Modifier
							</a></td>
						</tr>

						<%
						}
						%>
					</tbody>
				</table>

			</fieldset>
		</form>
	</div>

</footer>