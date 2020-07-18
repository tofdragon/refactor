# calisthenics README

- Employers 能够发布 jobs
- Employers 应能查看他们发布的 jobs 列表
- Jobseekers 能够保存 employers 已发布的 jobs 以便稍后查阅
- Jobseekers 能够申请 employers 已发布的 jobs
- Employers 可以发布两类 Jobs：JReq 和 ATS
- JReq 类型的 jobs 需要提供 resume 才能申请
- ATS 类型的 jobs 无需提供 resume
- Jobseekers 不能以他人的 resume 来申请 job
- Jobseekers 可以用不同的 resume 来申请不同的 jobs
- Jobseekers 应能查看自己保存的 jobs 列表
- Jobseekers 应能查看自己申请的 jobs 列表
- Employers 应能通过 job 和 date（申请日期）来查看申请了 jobs 的 jobseekers。如果可以，employer 还希望通过这两个条件联合查询在某个 date 申请了某个 job 的 jobseekers
- Employers 应能通过 job 和一个日期区间来查看申请了 jobs 的 jobseekers。如果可以，employer 还希望通过这两个条件联合查询在某个日期区间内申请了某个 job 的 jobseekers
- 系统应能生成任一 day 里提交了 jobs application 的所有 jobseekers 的报告
- 该报告应以 csv 或 html 格式给出
- Jobseekers 以其名字进行展示
- Employers 以其名字进行展示
- Jobs 以其 title 及发布它的 employer 名字进行展示
- 报告中应包含如下信息：jobseeker、job、employer、job application 日期
- 系统应能查看每个 employer 发布的每个 job 的 job application 数量
- 系统应能查看上述 job application 数量中成功和失败的 application 数量
  - [ongoing] 使用他人的 resume 申请也应计入失败的 application 中
- 系统应能处理不同 employer 发布的多个有相同 title 的 jobs
- 系统应能处理同名的多个 jobseekers
- 系统应能处理同名的多个 employers
- 系统应能处理同名的 jobseekers 和 employers