/**
 * 
 */

//*********** 
		//summer Note
		
		$("#write").click(function() {
			//다른 input들 검증.
			if($("#summernote").summernote('isEmpty')){
				alert("Empty");
			}else {
				$("#frm").submit();
			}
		});
		$("#summernote2").summernote({
			toolbar:[]
		});
		
		
		$("#summernote").summernote({
			
			height:800,
			callbacks:{
				onImageUpload:function(files){
					var formData = new FormData();
					formData.append('file', files[0]);
					
					$.ajax({
						type:"POST",
						url: "../ajax/summerFileUpload",
						data:formData,
						enctype: "multipart/form-data",
						cache: false,
					  	contentType: false,
					  	processData: false,
					  	success:function(data){
					  		data=data.trim();
					  		$("#summernote").summernote('editor.insertImage', data);
					  	}
					  	
						
					});
				},
				//OnImageUpload End
				onMediaDelete:function(files){
					var fileName = $(files[0]).attr('src');
					$.ajax({
						type:"POST",
						url:"../ajax/summerFileDelete",
						data:{fileName:fileName},
						success:function(data){
							console.log(data);
						}
						
					});
				}
				//onMediaDelete End
				
			}
		});
	
		//***********