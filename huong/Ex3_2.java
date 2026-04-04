/*
Hệ thống tiền Việt Nam có cấu trúc toán học đặc biệt, thỏa mãn tính chất then chốt:
Tổng giá trị lớn nhất có thể tạo ra từ các mệnh giá nhỏ (khi được dùng tối đa theo cách tối ưu) luôn luôn nhỏ hơn mệnh giá lớn tiếp theo.
Ví dụ:
Nếu không dùng tờ 5k, có thể dùng tối đa hai tờ 2k để đạt giá trị lớn nhất là 4k. (4k < 5k).
Nếu không dùng tờ 10k, có thể dùng một tờ 5k và hai tờ 2k để đạt tối đa 9k. (9k < 10k).
Nếu không dùng tờ 50k, có thể dùng hai tờ 20k và một tờ 5k, hai tờ 2k để đạt 49k. (49k < 50k).

Nhờ cấu trúc chặt chẽ này, nếu tại một bước không chọn tờ tiền mệnh giá lớn nhất có thể, sẽ buộc phải dùng một số lượng lớn 
các tờ tiền nhỏ hơn để bù đắp vào khoảng trống đó. Điều này chắc chắn sẽ làm tăng tổng số tờ tiền cần dùng. 
Do đó, việc luôn chọn tờ tiền lớn nhất trong hệ thống này là một lựa chọn "an toàn" và chắc chắn dẫn đến kết quả tối ưu toàn cục.


Thất bại với hệ thống mệnh giá {1, 3, 4} khi thối 6 đồng:
Đối với các hệ thống tiền tệ ngẫu nhiên, thuật toán Tham lam có thể không tìm được số lượng đồng tiền ít nhất.
Cách giải theo Thuật toán Tham lam: 
1. Chọn đồng lớn nhất không vượt quá 6: Tổng cộng cần 3 đồng (4 + 1 + 1).
2. Cách giải Tối ưu thực tế:Chỉ cần lấy 2 đồng 3.=> Tổng cộng cần 2 đồng (3 + 3).
Nguyên nhân thất bại: 
Thuật toán Tham lam đưa ra quyết định dựa trên thông tin hiện tại mà không xem xét lại tác động của quyết định đó 
trong tương lai. Việc vội vàng "tham lam" lấy đồng 4 khiến thuật toán rơi vào bẫy tối ưu cục bộ, 
buộc nó phải dùng các đồng 1 lẻ tẻ phía sau và bỏ lỡ phương án tối ưu toàn cục là dùng hai đồng 3.
 */