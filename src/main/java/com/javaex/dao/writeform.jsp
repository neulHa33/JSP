<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>��ȭ��ȣ��</h1>
	
	<h2>�����</h2>
	
	<p>
		��ȭ��ȣ�� ����Ϸ���<br>
		�Ʒ� �׸��� �����ϰ� "���" ��ư�� ����ϼ���
	</p>
	
	
	<form action="http://localhost:8080//phonebook3/pbc" method="">	
		<div>
		<label>�̸�(name)</label>
		<input type="text" name="name" value="">
		</div>
		
		<div>
		<label>�ڵ���(hp)</label>
		<input type="text" name="hp" value="">
		</div>
		
		<div>
		<label>ȸ��(company)</label>
		<input type="text" name="company" value="">
		</div>
		
		 <input type="text" name="aci" value="insert">
		<button type="submit">���</button>
	</form> 
	
	<br><br>
	<a href="">����Ʈ�������� �̵�</a>

</body>
</html>