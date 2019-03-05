package dto;

/*����� ������������ ��������� ���-�� � �������, ��� ���������� ��������� �� ������ ����������, ��� �������� ����� 
addItem � ������ Order, ������� ������������� ��������� ������� � ������, ����� ��� ����� ��������� ������. 

����� ���������� ������������ ��� ���������, � ��� ����� ����� �������� ���������� ��������� ������� �� ������.

�� �� �� ����� ������ �������� ��������� ������ Order ��� ��� �����, ��� ��� �� ������� �� ������ ������� 
(ItemDiscountService, UserService), ������� � ���� ������� ����� �������� �� ������ �������, 
������� ����� ���� ����� ���������� � ����� ������ � �. �.

�������, �� ����� �������������� �� �������, �� ����� �� ������� ����� �������� ��� ���� ������, 
������ ����������� � �� � �. �., ���� �� ���������� ���������� �� �����. 

�������, ����� ������ �������� ����������� ���������, �� ����� ������� ��� ����� ����������� ����� OrderDTO.

�� ������ ��������� � ���� �� ������, ������� ����� �������� �� ������, ������ ��� ����� Data Transfer Object. 

� ��� ����� ����������� ���������� ����� ������ ��� ��������. � ��� ����� � ��, ������� ��� � ������ Order, ��������, ������� total.

DTO � ��� ����� � �������, �� ��� ������. �� ������������ ��� �������� ������ ����� ������ ���������� 
� ����� ������������, ��� ������������ � ����������� �����.

*/

public class OrderDTO {

	private int id;
	private double subtotal;
	private double discount;
	private double total;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
