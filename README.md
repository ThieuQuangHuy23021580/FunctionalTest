# Functional Testing — Quán Cà Phê Sách

## I. Mô tả bài toán

**Bài toán:** Quy định giảm giá của quán cà phê Sách dựa trên số giờ khách ở lại trong ngày và loại khách hàng.

### Input

1. `hour` — số giờ khách ở lại (`1 ≤ hour ≤ 24`)
2. `userType` — loại khách hàng:
    - `REGULAR`: Khách thường
    - `MEMBER`: Khách đã đăng ký gói thành viên
    - `VIP`: Khách đã đăng ký gói VIP

**Điều kiện lỗi:**
- `hour < 1` hoặc `hour > 24`
- `userType` không thuộc `{REGULAR, MEMBER, VIP}`

### Output

Số phần trăm (%) giảm giá cho khách hàng.

### Quy tắc giảm giá

| Thời gian (giờ) | REGULAR | MEMBER | VIP |
| --------------- | :-----: | :----: | :-: |
| 1 – 3           | 0%      | 5%     | 10% |
| 4 – 6           | 5%      | 10%    | 15% |
| > 6             | 10%     | 15%    | 20% |

---

## II. Phân tích kết quả các test case

### 1. Kiểm thử biên (Boundary Value Analysis)

| Test | `hour` | `userType` | Kỳ vọng                    |
| :--: | :----: | :--------: | -------------------------- |
| T1   | 0      | `REGULAR`  | `IllegalArgumentException` |
| T2   | 1      | `REGULAR`  | 0%                         |
| T3   | 2      | `REGULAR`  | 0%                         |
| T4   | 3      | `MEMBER`   | 5%                         |
| T5   | 4      | `MEMBER`   | 10%                        |
| T6   | 5      | `MEMBER`   | 10%                        |
| T7   | 6      | `VIP`      | 15%                        |
| T8   | 7      | `MEMBER`   | 15%                        |
| T9   | 24     | `VIP`      | 20%                        |
| T10  | 25     | `VIP`      | `IllegalArgumentException` |

---

### 2. Kiểm thử bảng quyết định (Decision Table Testing)

#### Tập hợp rule

| Rule | Thời gian (giờ) | `userType` | Discount |
| :--: | :-------------: | :--------: | :------: |
| R1   | 1 – 3           | `REGULAR`  | 0%       |
| R2   | 1 – 3           | `MEMBER`   | 5%       |
| R3   | 1 – 3           | `VIP`      | 10%      |
| R4   | 4 – 6           | `REGULAR`  | 5%       |
| R5   | 4 – 6           | `MEMBER`   | 10%      |
| R6   | 4 – 6           | `VIP`      | 15%      |
| R7   | > 6             | `REGULAR`  | 10%      |
| R8   | > 6             | `MEMBER`   | 15%      |
| R9   | > 6             | `VIP`      | 20%      |

#### Điều kiện (Conditions) & Hành động (Actions)

**Điều kiện:**

| Ký hiệu | Điều kiện             |
| :-----: | --------------------- |
| C1      | `userType = REGULAR`  |
| C2      | `userType = MEMBER`   |
| C3      | `userType = VIP`      |
| C4      | `hour < 1`            |
| C5      | `1 ≤ hour ≤ 3`        |
| C6      | `4 ≤ hour ≤ 6`        |
| C7      | `6 < hour ≤ 24`       |
| C8      | `hour > 24`           |

**Hành động:**

| Ký hiệu | Hành động              |
| :-----: | ---------------------- |
| E1      | Discount = 0%          |
| E2      | Discount = 5%          |
| E3      | Discount = 10%         |
| E4      | Discount = 15%         |
| E5      | Discount = 20%         |
| E6      | Input không hợp lệ     |

#### Bảng quyết định đầy đủ

|              |                    | R1 | R2 | R3 | R4 | R5 | R6 | R7 | R8 | R9 | R10 | R11 | R12 | R13 | R14 | R15 |
| :----------: | ------------------ | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
| **Điều kiện** | C1: REGULAR?      | T  | T  | T  | T  | T  | F  | F  | F  | F  | F   | F   | F   | F   | F   | F   |
|              | C2: MEMBER?        | –  | –  | –  | –  | –  | T  | T  | T  | T  | T   | F   | F   | F   | F   | F   |
|              | C3: VIP?           | –  | –  | –  | –  | –  | –  | –  | –  | –  | –   | T   | T   | T   | T   | T   |
|              | C4: hour < 1?      | T  | F  | F  | F  | F  | T  | F  | F  | F  | F   | T   | F   | F   | F   | F   |
|              | C5: 1 ≤ hour ≤ 3? | –  | T  | F  | F  | F  | –  | T  | F  | F  | F   | –   | T   | F   | F   | F   |
|              | C6: 4 ≤ hour ≤ 6? | –  | –  | T  | F  | F  | –  | –  | T  | F  | F   | –   | –   | T   | F   | F   |
|              | C7: 6 < hour ≤ 24?| –  | –  | –  | T  | F  | –  | –  | –  | T  | F   | –   | –   | –   | T   | F   |
|              | C8: hour > 24?     | –  | –  | –  | –  | T  | –  | –  | –  | –  | T   | –   | –   | –   | –   | T   |
| **Hành động** | E1: Discount = 0% |    | X  |    |    |    |    |    |    |    |     | X   |     |     |     |     |
|              | E2: Discount = 5%  |    |    | X  |    |    |    | X  |    |    |     |     |     |     |     |     |
|              | E3: Discount = 10% |    |    |    | X  |    |    |    | X  |    |     |     | X   |     |     |     |
|              | E4: Discount = 15% |    |    |    |    |    |    |    |    | X  |     |     |     | X   |     |     |
|              | E5: Discount = 20% |    |    |    |    |    |    |    |    |    |     |     |     |     | X   |     |
|              | E6: Input lỗi      | X  |    |    |    | X  | X  |    |    |    | X   |     |     |     |     | X   |
