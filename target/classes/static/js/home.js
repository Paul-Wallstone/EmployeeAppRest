
$(document).ready(function () {
    $('#chkParent').click(function () {
        var isChecked = $(this).prop("checked");
        $('#tblData tr:has(td)').find('input[type="checkbox"]').prop('checked', isChecked);
    });

    $('#tblData tr:has(td)').find('input[type="checkbox"]').click(function () {
        var isChecked = $(this).prop("checked");
        var isHeaderChecked = $("#chkParent").prop("checked");
        if (isChecked == false && isHeaderChecked)
            $("#chkParent").prop('checked', isChecked);
        else {
            $('#tblData tr:has(td)').find('input[type="checkbox"]').each(function () {
                if ($(this).prop("checked") == false)
                    isChecked = false;
            });
            console.log(isChecked);
            $("#chkParent").prop('checked', isChecked);
        }
    });
});

$('.btn-outline-success').click(function () {
    var $modal =$('#exampleModal2').clone();

    var $btn = $(this);
    var Id = $btn.attr('data-id');
    var firstname = $btn.attr('data-firstname');
    var lastname = $btn.attr('data-lastname');
    var departmentId = $btn.attr('data-departmentId');
    var gender = $btn.attr('data-gender');
    var jobTitle = $btn.attr('data-jobTitle');
    var date_of_birth = $btn.attr('data-date_of_birth');

    $modal.find('[name="firstName"]').val(firstname);
    $modal.find('[name="lastName"]').val(lastname);
    $modal.find('[name="departmentId"]').val(departmentId);
    $modal.find('[name="job_title"]').val(jobTitle);
    $modal.find('[name="date_of_birth"]').val(date_of_birth);
    $modal.find('[name="gender"]').val(gender);
    $modal.find('[name="employeeId"]').val(Id);

    $modal.modal('show');
});