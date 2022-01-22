<script src="<%= request.getContextPath() %>/Template/js/core/popper.min.js"></script>
<script src="<%= request.getContextPath() %>/Template/js/core/bootstrap.min.js"></script>
<script src="<%= request.getContextPath() %>/Template/js/plugins/perfect-scrollbar.min.js"></script>
<script src="<%= request.getContextPath() %>/Template/js/plugins/smooth-scrollbar.min.js"></script>
<script>
    var win = navigator.platform.indexOf('Win') > -1;
    if (win && document.querySelector('#sidenav-scrollbar')) {
      var options = {
        damping: '0.5'
      }
      Scrollbar.init(document.querySelector('#sidenav-scrollbar'), options);
    }
  </script>
  <script async="" defer="" src="https://buttons.github.io/buttons.js"></script>
  <script src="<%= request.getContextPath() %>/Template/js/soft-ui-dashboard.min.js?v=1.0.3"></script>