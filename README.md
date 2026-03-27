# Thuật Toán Ứng Dụng - Ôn Thi Vấn Đáp Cuối Kỳ

Dự án này chứa các bài tập chuẩn bị cho kỳ thi vấn đáp cuối kỳ môn Thuật toán ứng dụng.

## Phân Công Nhóm

| Thành viên | Bài tập phân công | Thư mục |
| :--- | :--- | :--- |
| **Trần Khải** | 1.1, 2.1, 3.1, 4.1 | [khai/](khai/) |
| **Nguyễn Lan Hương** | 2.2, 3.2, 3.3, 4.2, 5.1 | [huong/](huong/) |
| **Nguyễn Hoàng Diệu Châu** | 1.2, 3.4, 3.5, 4.3, 5.2 | [chau/](chau/) |
| **Nghiêm Gia Bảo (C)** | 1.3, 2.3, 3.6, 4.4, 5.3 | [bao/](bao/) |

---

## Hướng Dẫn Quy Trình Làm Việc

Để đảm bảo quản lý mã nguồn hiệu quả, các thành viên vui lòng tuân thủ quy trình sau:

### 1. Clone Project
Mở terminal và chạy lệnh:
```bash
git clone https://github.com/baoOyster/ttud_cuoi_ky
cd ttud_cuoi_ky
```

### 2. Tạo Branch Theo Tên
Mỗi thành viên làm việc trên một nhánh (branch) riêng mang tên mình (không dấu, viết liền):
```bash
# Ví dụ: Trần Khải tạo branch
git checkout -b khai
```

### 3. Thực Hiện Bài Tập
- Làm bài trong thư mục đã được phân công.
- Đảm bảo file đặt tên đúng định dạng (ví dụ: `Ex1_1.java`).

### 4. Đẩy Code Lên GitHub
Sau khi hoàn thành hoặc có thay đổi quan trọng:
```bash
git add .
git commit -m "Hoàn thành bài tập ExX_Y"
git push origin <tên-branch-của-bạn>
```

### 5. Tạo Pull Request (PR)
- Truy cập vào repository trên GitHub.
- Nhấn nút **"Compare & pull request"** cho branch bạn vừa push.
- Đặt tiêu đề PR: `[Họ Tên] Hoàn thành bài X.Y`.
- Chờ Bảo review và merge vào branch `main`.

---
*Lưu ý: Có điểm tập thể (3đ) cho số lượng bài nhóm hoàn thành và vấn đáp cá nhân (7đ) dựa trên bài đã làm và mức độ hiểu code. Nên mọi người nên comment kỹ nhé, điều này sẽ giúp mọi người trong lúc vấn đáp*