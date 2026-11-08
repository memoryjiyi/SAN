# SAN

UML 类图 → Java 代码实现。三个模型对应三张类图，全部编译可运行，
多重度和 OCL 约束在代码中强制（违反即抛异常）。

## 模型对照

| 类图 | 包 | 内容 |
|---|---|---|
| ClassDiagram1 | `san.college` | College 1—1..* Building；College 1—1..* Course；约束 **Course must be held in a Building**（构造 `Course` 时不给 `Building` 直接抛异常） |
| Main / ClassDiagram2 | `san.thoroughbred` | Thoroughbred：mother / father / birthyear，方法 `getCurrentAge()` / `getFather()` / `getMother()` |
| ClassDiagram3 | `san.school` | School 1—1..* Department；Department 1—1..* Instructor；School 1—0..* Student；Student 1—1..5 Subject；Instructor 1—1..3 Subject |

## 编译与运行

```bash
javac -encoding UTF-8 -d out $(find src -name "*.java")

# 三个演示
java -cp out san.college.CollegeDemo        # 约束：Course 必须在 Building 中
java -cp out san.thoroughbred.ThoroughbredDemo
java -cp out san.school.SchoolDemo          # 多重度：学生最多 5 门课、讲师最多 3 门课
```

Windows PowerShell：

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem src -Recurse -Filter *.java).FullName
java -cp out san.school.SchoolDemo
```

## 实现要点

- **双向关联**：一侧持引用，另一侧包内可见的 `attachTo` 维护，避免循环暴露。
- **多重度**：`Student.take()` 超 5 门抛 `IllegalStateException`；`Instructor.teach()` 超 3 门同理。
- **OCL 约束**：`Course` 的 `Building` 在构造器中必填，对象不可能处于「未安排教室」的状态。
- 集合对外返回 `Collections.unmodifiableList`，外部只能通过方法修改关联。

## 预期输出（SchoolDemo）

```
多重度生效: Student 王同学 can take at most 5 subjects
School 计算机学院：2 个系，2 名学生
  王同学 选修 5 门课
  赵同学 选修 2 门课
  软件工程系 张老师 讲授 2 门课
  网络工程系 李老师 讲授 2 门课
```
