package com.duongdk.hust.it4785.gmailclonebyusingrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var emailList = ArrayList<EmailModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sampleEmails = listOf(
            EmailModel(
                "john.doe@gmail.com",
                "Phỏng vấn công việc",
                "Chào bạn,\n\nTôi rất vui được thông báo rằng bạn đã được chọn để tham gia buổi phỏng vấn công việc tại công ty chúng tôi vào ngày mai. Chúng ta sẽ bắt đầu lúc 10 giờ sáng tại địa chỉ sau đây: 123 Main Street, Thành phố ABC. Hãy mang theo bản sao giấy tờ tùy thân và sẵn sàng trả lời một số câu hỏi về kỹ năng và kinh nghiệm của bạn.\n\nChúng tôi rất mong đợi cuộc gặp gỡ với bạn.\n\nTrân trọng,\nJohn Doe",
                1677552000 // 01-03-2023 10:00:00
            ),
            EmailModel(
                "tech.news@example.com",
                "Tin tức công nghệ mới nhất",
                "Chào bạn,\n\nDưới đây là những tin tức công nghệ mới nhất:\n\n1. Smartphone mới ra mắt với camera ấn tượng.\n2. Công nghệ trí tuệ nhân tạo tiến bộ trong lĩnh vực y tế.\n3. Facebook công bố dự án mới về thực tế ảo.\n\nHãy đọc bài viết đính kèm để biết thêm chi tiết.\n\nTrân trọng,\nTech News Team",
                1677638400 // 02-03-2023 10:00:00
            ),
            EmailModel(
                "alice.smith@gmail.com",
                "Dự án blockchain mới",
                "Chào bạn,\n\nTôi muốn thông báo về dự án blockchain mới mà chúng tôi đang phát triển. Chúng tôi tin rằng nó sẽ thay đổi cách chúng ta tương tác với thị trường tài chính. Dự án này đang tìm kiếm các nhà phát triển và chuyên gia blockchain để tham gia. Nếu bạn quan tâm và muốn biết thêm chi tiết, xin hãy liên hệ với tôi.\n\nTrân trọng,\nAlice Smith",
                1677724800 // 03-03-2023 10:00:00
            ),
            EmailModel(
                "job.application@example.com",
                "Xin việc tại công ty ABC",
                "Chào phòng nhân sự,\n\nTôi gửi đơn xin việc tại công ty ABC theo yêu cầu của thông báo tuyển dụng. Tôi đã gửi hồ sơ và thông tin cá nhân chi tiết qua đính kèm. Rất mong được cơ hội phỏng vấn và làm việc tại công ty của bạn.\n\nTrân trọng,\nJane Johnson",
                1677811200 // 04-03-2023 10:00:00
            ),
            EmailModel(
                "blockchain.event@example.com",
                "Sự kiện Blockchain 2023",
                "Chào bạn,\n\nChúng tôi vô cùng phấn khích thông báo về Sự kiện Blockchain 2023 sắp tới. Đây là cơ hội tuyệt vời để cập nhật kiến thức về blockchain và gặp gỡ các chuyên gia hàng đầu trong lĩnh vực này. Hãy đăng ký và tham gia để tham dự sự kiện này.\n\nTrân trọng,\nBlockchain Event Team",
                1677897600 // 05-03-2023 10:00:00
            ),
            EmailModel(
                "contact@cryptoexchange.com",
                "Thông báo giao dịch tiền điện tử",
                "Chào bạn,\n\nChúng tôi xác nhận giao dịch mua 100 đơn vị Bitcoin tại sàn giao dịch của chúng tôi. Xin vui lòng kiểm tra tài khoản của bạn để xem chi tiết giao dịch. Nếu bạn có bất kỳ câu hỏi nào, xin hãy liên hệ với chúng tôi.\n\nTrân trọng,\nCrypto Exchange Support",
                1677984000 // 06-03-2023 10:00:00
            ),
            EmailModel(
                "event@techconference.com",
                "Thông tin về Hội nghị Công nghệ 2023",
                "Chào bạn,\n\nHội nghị Công nghệ 2023 đang đến gần và chúng tôi có một số cập nhật quan trọng:\n\n1. Thời gian và địa điểm: Ngày 15 tháng 11 tại Trung tâm Hội nghị XYZ.\n2. Danh sách các diễn giả hàng đầu.\n3. Các phiên thảo luận và chủ đề quan trọng.\n\nHãy đăng ký tham gia để không bỏ lỡ cơ hội này.\n\nTrân trọng,\nTech Conference Team",
                1678070400 // 07-03-2023 10:00:00
            ),
            EmailModel(
                "user1@gmail.com",
                "Bản tin hàng tuần",
                "Chào bạn,\n\nDưới đây là bản tin hàng tuần với những tin tức và sự kiện quan trọng trong tuần này:\n\n1. Cập nhật về blockchain và tiền điện tử.\n2. Hướng dẫn cách tạo ứng dụng di động bằng Kotlin.\n3. Thông tin về việc làm trong lĩnh vực công nghệ.\n\nHãy đọc để cập nhật thông tin.\n\nTrân trọng,\nNewsletter Team",
                1678156800 // 08-03-2023 10:00:00
            ),
            EmailModel(
                "job.interview@example.com",
                "Chúc mừng, bạn đã được chọn cho vị trí kỹ sư phần mềm",
                "Chào bạn,\n\nTôi xin chúc mừng bạn đã được chọn cho vị trí kỹ sư phần mềm tại công ty chúng tôi sau buổi phỏng vấn gần đây. Chúng ta rất mong được làm việc cùng bạn và chúng tôi sẽ liên hệ với bạn để thảo luận về chi tiết hợp đồng và lịch làm việc.\n\nTrân trọng,\nHành động Nhân sự",
                1678243200 // 09-03-2023 10:00:00
            )
        )
        val additionalEmails = listOf(
            EmailModel(
                "user2@example.com",
                "Thông báo về cuộc họp quan trọng",
                "Chào bạn,\n\nChúng tôi sẽ có một cuộc họp quan trọng vào ngày mai lúc 14:00 tại phòng họp số 3. Vui lòng đảm bảo bạn có mặt đúng giờ để tham gia cuộc họp này.\n\nTrân trọng,\nQuản lý dự án",
                1678334400 // 10-03-2023 14:00:00
            ),
            EmailModel(
                "tech.blog@example.com",
                "Bài viết mới: Kotlin cho người mới bắt đầu",
                "Chào bạn,\n\nChúng tôi vừa đăng một bài viết mới trên blog về lập trình Kotlin cho người mới bắt đầu. Hãy đọc và cải thiện kỹ năng lập trình Kotlin của bạn.\n\nTrân trọng,\nTech Blog Team",
                1678420800 // 11-03-2023 10:00:00
            ),
            EmailModel(
                "job.application@example.com",
                "Phản hồi đơn xin việc",
                "Chào bạn,\n\nChúng tôi đã xem xét đơn xin việc của bạn và muốn mời bạn tham gia buổi phỏng vấn vào ngày mai lúc 9:00 tại văn phòng công ty chúng tôi. Hãy mang theo hồ sơ và giấy tờ liên quan.\n\nTrân trọng,\nPhòng Nhân sự",
                1678507200 // 12-03-2023 10:00:00
            ),
            EmailModel(
                "event@conference.com",
                "Thông báo về Hội nghị Công nghệ",
                "Chào bạn,\n\nChúng tôi muốn thông báo rằng Hội nghị Công nghệ sẽ diễn ra vào ngày 20 tháng 3 tại Trung tâm Hội nghị XYZ. Đây là sự kiện không thể bỏ lỡ cho những người làm việc trong lĩnh vực công nghệ.\n\nTrân trọng,\nBan Tổ chức Hội nghị",
                1678593600 // 13-03-2023 10:00:00
            ),
            EmailModel(
                "user3@example.com",
                "Bản tin hàng tuần",
                "Chào bạn,\n\nChúng tôi vừa gửi bản tin hàng tuần với những tin tức, bài viết mới và thông tin cập nhật về công nghệ. Hãy đọc và cập nhật kiến thức của bạn.\n\nTrân trọng,\nNewsletter Team",
                1678680000 // 14-03-2023 10:00:00
            ),
            EmailModel(
                "blockchain.news@example.com",
                "Tin tức mới nhất về Blockchain",
                "Chào bạn,\n\nDưới đây là những tin tức mới nhất về blockchain:\n\n1. Các ứng dụng blockchain trong lĩnh vực y tế.\n2. Sự phát triển của tiền điện tử.\n3. Blockchain trong lĩnh vực tài chính.\n\nHãy đọc bài viết đính kèm để biết thêm chi tiết.\n\nTrân trọng,\nBlockchain News Team",
                1678766400 // 15-03-2023 10:00:00
            ),
            EmailModel(
                "user4@example.com",
                "Phỏng vấn ứng viên",
                "Chào bạn,\n\nChúng tôi xin mời bạn tham gia buổi phỏng vấn vào ngày 17 tháng 3 lúc 15:00 tại văn phòng công ty chúng tôi. Hãy chuẩn bị và đảm bảo bạn có mặt đúng giờ.\n\nTrân trọng,\nPhòng Nhân sự",
                1678852800 // 16-03-2023 10:00:00
            ),
            EmailModel(
                "news@techmagazine.com",
                "Bản tin Công nghệ",
                "Chào bạn,\n\nDưới đây là bản tin hàng tuần với các tin tức và bài viết mới về công nghệ:\n\n1. Công nghệ 5G đang thay đổi cách chúng ta sử dụng di động.\n2. Sự ra đời của máy tính siêu vi mô.\n3. Các công ty công nghệ hàng đầu năm 2023.\n\nHãy đọc để cập nhật thông tin.\n\nTrân trọng,\nTech Magazine Team",
                1678939200 // 17-03-2023 10:00:00
            ),
            EmailModel(
                "user5@example.com",
                "Chào bạn, tôi là Jane",
                "Chào bạn,\n\nTôi là Jane, tôi đã thấy thông tin liên hệ của bạn qua một cuộc họp gần đây và muốn kết nối với bạn để thảo luận về một dự án có liên quan đến công nghệ. Hãy liên hệ với tôi để bắt đầu cuộc trò chuyện.\n\nTrân trọng,\nJane",
                1679025600 // 18-03-2023 10:00:00
            )
        )

        emailList.addAll(sampleEmails)
        emailList.addAll(additionalEmails)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EmailAdapter(this.emailList)
    }
}