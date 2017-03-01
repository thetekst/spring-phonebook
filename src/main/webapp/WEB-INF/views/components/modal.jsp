<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">Edit</h4>
            </div>
            <div class="modal-body">
                <form id="updateForm" method="post" class="form-inline">
                    <input type="hidden" value="" name="userid" id="userid">
                    <div class="form-group">
                        <input type="text" class="form-control" id="username" name="username">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="phone" name="phone">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" id="saveModal" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>