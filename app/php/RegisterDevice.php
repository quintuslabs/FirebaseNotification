<?php
/**
 * FirebaseNotification
 * https://github.com/quintuslabs/FirebaseNotification
 * Created on 18-Nov-2018.
 * Created by : Santosh Kumar Dash:- http://santoshdash.epizy.com
 */
	require_once 'DbOperation.php';
	$response = array(); 

	if($_SERVER['REQUEST_METHOD']=='POST'){

		$token = $_POST['token'];
		$email = $_POST['email'];
		$name = $_POST['name'];

		$db = new DbOperation(); 

		$result = $db->registerDevice($name,$email,$token);

		if($result == 0){
			$response['error'] = false; 
			$response['message'] = 'Device registered successfully';
		}elseif($result == 2){
			$response['error'] = true; 
			$response['message'] = 'Device already registered';
		}else{
			$response['error'] = true;
			$response['message']='Device not registered';
		}
	}else{
		$response['error']=true;
		$response['message']='Invalid Request...';
	}

	echo json_encode($response);