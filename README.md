#Let’s Go project

#### Lets-go-generator
````
Java project.
Thư viện GreenDAO để tự động generate ra code database
Sau khi chạy file MainGeneration.java -> được code trong thư mục: Lets-go-generator-out-ver(1) -> copy đè vào package: src/com.oic.bookreminder.models.tables
````

#### Lets-go
````
Android project.

Quy tắc chung:
  + thư mục /api: chứa các interface
  + thư mục /implement: các class cài đặt interface trong /api
  + các class có tiền tố Base… : abstract class
  + hằng số static final viết hoa tất cả, cách nhau dấu gạch dưới (_)
  + nên sử dụng @styles thay vì chèn trực tiếp style cho views trong layout.
     - style bao gồm các thuộc tính hiển thị (màu sắc, orient, text-style…)
     - style không bao gồm kích thước (margin, padding, align…)

Các files:
  + LetsGo.iml: nếu sử dụng Intellij (thay vì Eclipse) thì file này tự động sinh ra.

src/com.oic.bookreminder/
  + app: chứa các màn hình của ứng dụng (Fragment, Adapter…)
  + config: các file cấu hình (Database, Debug, Log, Network …)
  + models: các table trong database, các Helper để gọi database…
  + network: các api, class helper gọi đến backend, facebook api…
  + common: các thành phần dùng chung giữa các màn hình (custom views, utils,..)
  + vendor: các class tiện ích từ các nguồn khác, không phải do mình viết ra.
````

##### Tham khảo thêm: [https://github.com/futurice/android-best-practices](Cấu trúc project Android)