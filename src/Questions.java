
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Majd Talji <en.majd.talji@gmail.com>
 */
class Answer {

    String text;
    boolean isCorrect;

    public Answer(String text, boolean isCorrect) {
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public Answer(String text) {
        this.text = text;
        this.isCorrect = false;
    }

    public String getText() {
        return this.text;
    }

    public boolean isCorrect() {
        return this.isCorrect;
    }

}

class Question {

    String phrase;
    ArrayList<Answer> answers = new ArrayList<>();

    public Question(String phrase, Answer[] answers) {
        this.phrase = phrase;
        this.answers.add(answers[0]);
        this.answers.add(answers[1]);
        this.answers.add(answers[2]);
        this.answers.add(answers[3]);
    }

    public String getPhrase() {
        return this.phrase;
    }

    public Answer getAnswer(int answerIndex) {
        return this.answers.get(answerIndex);
    }

}

public class Questions {

    ArrayList<Question> al = new ArrayList<>();

    public Questions() {
        createQuestions();
    }

    public Question getQuestion() {
        Question question = al.get(0);
        al.remove(0);
        return question;
    }

    public void createQuestions() {

        al.add(new Question("كان من خلق النبي صلى الله عليه وسلم؟",
                new Answer[]{
                    new Answer("الصدق", true),
                    new Answer("الغضب"),
                    new Answer("عدم التواضع"),
                    new Answer("عدم الصدق"),})
        );

        al.add(new Question("ما اسم والد النبي صلى الله عليه وسلم؟",
                new Answer[]{
                    new Answer("عبدالله", true),
                    new Answer("محمد"),
                    new Answer("إبراهيم"),
                    new Answer("عبد مناف"),})
        );

        al.add(new Question("ما اسم والدة النبي صلى الله عليه وسلم؟",
                new Answer[]{
                    new Answer("آمنة بنت وهب", true),
                    new Answer("حليمة السعدية"),
                    new Answer("فاطمة بنت حبيش"),
                    new Answer("خديجة بنت خويلد"),})
        );

        al.add(new Question("في أي يوم ولد النبي صلى الله عليه وسلم؟",
                new Answer[]{
                    new Answer("في الثاني عشر من ربيع الأول", true),
                    new Answer("في الأول من صفر"),
                    new Answer("في الثاني من محرم"),
                    new Answer("في السابع من شوال"),})
        );

        al.add(new Question("كم كان عمر النبي عندما توفي والده؟",
                new Answer[]{
                    new Answer("كان جنينا في بطن أمه", true),
                    new Answer("كان رضيعا"),
                    new Answer("كان طفلا"),
                    new Answer("كان شابا"),})
        );

        al.add(new Question("ما اسم عمه الذي كفله وحماه من المشركين؟",
                new Answer[]{
                    new Answer("أبو طالب", true),
                    new Answer("أبو لهب"),
                    new Answer("أبو جهل"),
                    new Answer("أبو عبيدة"),})
        );

        al.add(new Question("ما اسم زوجة النبي صلى الله عليه وسلم؟",
                new Answer[]{
                    new Answer("خديجة بنت خويلد", true),
                    new Answer("فاطمة بنت قبيس"),
                    new Answer("مريم بنت الزبير"),
                    new Answer("الخنساء"),})
        );

        al.add(new Question("ما اسم الغار الذي كان النبي يعبد ربه فيه؟",
                new Answer[]{
                    new Answer("غار حراء", true),
                    new Answer("غار ثور"),
                    new Answer("غار علقمة"),
                    new Answer("غار تميم"),})
        );

        al.add(new Question("كم كان عمر النبي عندما نزل عليه الوحي؟",
                new Answer[]{
                    new Answer("41 سنة", true),
                    new Answer("50 سنة"),
                    new Answer("60 سنة"),
                    new Answer("44 سنة"),})
        );

        al.add(new Question("ما اسم ملك الوحي الذي نزل على النبي في الغار؟",
                new Answer[]{
                    new Answer("جبريل", true),
                    new Answer("ميكائيل"),
                    new Answer("إسرافيل"),
                    new Answer("ملك الجبال"),})
        );

        al.add(new Question("من أول من أسلم من النساء؟",
                new Answer[]{
                    new Answer("خديجة بنت خويلد", true),
                    new Answer("فاطمة بنت قبيس"),
                    new Answer("عائشة بنت أبي بكر"),
                    new Answer("زينب أم المساكين"),})
        );

        al.add(new Question("من أول من أسلم من الصبيان؟",
                new Answer[]{
                    new Answer("علي بن أبي طالب", true),
                    new Answer("زيد بن حارثة"),
                    new Answer("عبدالله بن عمر"),
                    new Answer("عبدالله بن عباس"),})
        );

        al.add(new Question("من أول من أسلم من الرجال؟",
                new Answer[]{
                    new Answer("أبو بكر الصديق", true),
                    new Answer("عثمان بن عفان"),
                    new Answer("عبدالله بن مسعود"),
                    new Answer("عمر بن الخطاب"),})
        );

        al.add(new Question("ما اسم القبيلة التي حاربت النبي صلى الله عليه وسلم؟",
                new Answer[]{
                    new Answer("قريش", true),
                    new Answer("بنو تميم"),
                    new Answer("ثقيف"),
                    new Answer("بنو قيس"),})
        );

        al.add(new Question("أين كان يعيش النبي صلى الله عليه وسلم؟",
                new Answer[]{
                    new Answer("مكة المكرمة", true),
                    new Answer("العراق"),
                    new Answer("الشام"),
                    new Answer("اليمن"),})
        );

        al.add(new Question("ما اسم عمَ النبي الذي لقب بأسد الله؟",
                new Answer[]{
                    new Answer("حمزة بن عبد المطلب", true),
                    new Answer("أبو لهب"),
                    new Answer("أبو طالب"),
                    new Answer("العباس"),})
        );

        al.add(new Question("إلى أي بلاد هاجر المسلمون أول مرة؟",
                new Answer[]{
                    new Answer("الحبشة", true),
                    new Answer("اليمن "),
                    new Answer("الشام"),
                    new Answer("نجد"),})
        );

        al.add(new Question("ما اسم الصحابي الذي قاد المسلمين إلى الحبشة؟",
                new Answer[]{
                    new Answer("جعفر بن أبي طالب", true),
                    new Answer("حذيفة بن اليمان"),
                    new Answer("أبو عبيدة بن الجراح"),
                    new Answer("سعد بن معاذ"),})
        );

        al.add(new Question("ماذا كان اسم ملك الحبشة؟",
                new Answer[]{
                    new Answer("النجاشي", true),
                    new Answer("كسرى"),
                    new Answer("قيصر"),
                    new Answer("النمرود"),})
        );

        al.add(new Question("ماذا كان اسم ملك الحبشة؟",
                new Answer[]{
                    new Answer("النجاشي", true),
                    new Answer("كسرى"),
                    new Answer("قيصر"),
                    new Answer("النمرود"),})
        );

        al.add(new Question("تقع الكعبة المشرفة في ...",
                new Answer[]{
                    new Answer("مكة المكرمة", true),
                    new Answer("خيبر"),
                    new Answer("الشام"),
                    new Answer("يثرب"),})
        );

        al.add(new Question("يقع المسجد الأقصى في ...",
                new Answer[]{
                    new Answer("القدس", true),
                    new Answer("الطائف "),
                    new Answer("يثرب"),
                    new Answer("اليمن"),})
        );

        al.add(new Question("القدس عاصمة أي من الدول الآتية؟",
                new Answer[]{
                    new Answer("فلسطين", true),
                    new Answer("العراق"),
                    new Answer("اليمن"),
                    new Answer("لبنان"),})
        );

        al.add(new Question("ما هما الرحلتان العظيمتان اللتان قام بهما الرسول؟",
                new Answer[]{
                    new Answer("الاسراء والمعراج", true),
                    new Answer("حطين"),
                    new Answer("عين جالوت"),
                    new Answer("أحد"),})
        );

        al.add(new Question("ماذا فرض الله تعالى في ليلة الاسراء والمعراج؟",
                new Answer[]{
                    new Answer("الصلوات الخمس", true),
                    new Answer("صوم رمضان"),
                    new Answer("حج البيت"),
                    new Answer("الزكاة"),})
        );

        al.add(new Question("ما اسم أول بيعة للأنصار في الإسلام؟",
                new Answer[]{
                    new Answer("بيعة العقبة", true),
                    new Answer("بيعة نجد"),
                    new Answer("بيعة ثقيف"),
                    new Answer("بيعة الخزرج"),})
        );

        al.add(new Question("إلى أين هاجر المسلمون بعد الحبشة؟",
                new Answer[]{
                    new Answer("المدينة المنورة", true),
                    new Answer("مكة"),
                    new Answer("اليمن"),
                    new Answer("الشام"),})
        );

        al.add(new Question("ماذا كان لقب المسلمين من أهل المدينة؟",
                new Answer[]{
                    new Answer("الأنصار", true),
                    new Answer("المهاجرين"),
                    new Answer("الفقراء"),
                    new Answer("المسافرين"),})
        );

        al.add(new Question("ماذا كان لقب المسلمين القادمين من مكة؟",
                new Answer[]{
                    new Answer("المهاجرين", true),
                    new Answer("الانصار"),
                    new Answer("المقاتلين"),
                    new Answer("الاغنياء"),})
        );

        al.add(new Question("من الصحابي الذي هاجر مع النبي إلى المدينة المنورة؟",
                new Answer[]{
                    new Answer("أبو بكر الصديق", true),
                    new Answer("عمر بن الخطاب"),
                    new Answer("علي بن أبي طالب"),
                    new Answer("عثمان بن عفان"),})
        );

        al.add(new Question("ما اسم الغار الذي ارتاح فيه النبي قبل الوصول الى المدينة؟",
                new Answer[]{
                    new Answer("غار ثور", true),
                    new Answer("غار حراء"),
                    new Answer("غار شعلان"),
                    new Answer("غار آدم"),})
        );

        al.add(new Question("ماذا قال النبي لأبي بكر وهما في الغار؟",
                new Answer[]{
                    new Answer("لا تحزن إن الله معنا", true),
                    new Answer("لا تحزن سنموت سويا"),
                    new Answer("لا تحزن لن نقتل"),
                    new Answer("لا تحزن سنهزمهم"),})
        );

        al.add(new Question("ما هو أول أمر فعله النبي عندما وصل إلى المدينة؟",
                new Answer[]{
                    new Answer("بنى مسجدا", true),
                    new Answer("أعطاهم مالا"),
                    new Answer("أخذ تمرا"),
                    new Answer("اشترى منزلا"),})
        );

        al.add(new Question("في بيت من أقام النبي عندما وصل إلى المدينة؟",
                new Answer[]{
                    new Answer("أبو أيوب الأنصاري", true),
                    new Answer("سعد بن معاذ"),
                    new Answer("عبادة بن الصامت"),
                    new Answer("معاذ بن جبل"),})
        );

        al.add(new Question("ماذا فعل النبي بعد بناء المسجد؟",
                new Answer[]{
                    new Answer("آخى بين المهاجرين والأنصار", true),
                    new Answer("حاسب الظالمين"),
                    new Answer("بناء القصور"),
                    new Answer("الراحة بعد السفر"),})
        );

        al.add(new Question("من كان يسكن في المدينة بجانب المسلمين؟",
                new Answer[]{
                    new Answer("اليهود", true),
                    new Answer("الروم"),
                    new Answer("الفرس"),
                    new Answer("النصارى"),})
        );

        al.add(new Question("ماذا فعل النبي بعد المؤخاة بين المسلمين؟",
                new Answer[]{
                    new Answer("أقام معاهدة مع اليهود", true),
                    new Answer("حارب اليهود"),
                    new Answer("دعى الناس للطعام"),
                    new Answer("نصب نفسه ملكا"),})
        );

        al.add(new Question("في أي سنة بعد الهجرة فرض الله صيام رمضان؟",
                new Answer[]{
                    new Answer("السنة الثانية", true),
                    new Answer("السنة الأولى"),
                    new Answer("السنة الخامسة"),
                    new Answer("السنة الرابعة"),})
        );

        al.add(new Question("أول سرية في الاسلام كانت بقيادة من ...",
                new Answer[]{
                    new Answer("عبدالله بن جحش", true),
                    new Answer("ابن مسعود"),
                    new Answer("ابو عبيدة"),
                    new Answer("خالد بن الوليد"),})
        );

        al.add(new Question("ماذا كان اسم رأس المنافقين في المدينة؟",
                new Answer[]{
                    new Answer("عبدالله بن أبي سلول", true),
                    new Answer("عبدالله بن سلام"),
                    new Answer("ولعان الأعمى"),
                    new Answer("سعيد المصلوب"),})
        );

        al.add(new Question("ماذا كان اسم ـول معركة بين المسلمين والمشركين؟",
                new Answer[]{
                    new Answer("معركة بدر", true),
                    new Answer("معركة ذات السلاسل"),
                    new Answer("معركة القادسية"),
                    new Answer("معركة أحد"),})
        );

        al.add(new Question("في أي سنة كانت معركة بدر الكبرى؟",
                new Answer[]{
                    new Answer("السنة الثانية", true),
                    new Answer("السنة الثالثة"),
                    new Answer("السنة السابعة"),
                    new Answer("السنة الرابعة"),})
        );

        al.add(new Question("كم كان عدد المسلمين في معركة بدر؟",
                new Answer[]{
                    new Answer("313 رجلا", true),
                    new Answer("500 رجل"),
                    new Answer("1000 رجل"),
                    new Answer("800 رجل"),})
        );

        al.add(new Question("كم كان عدد المشركين في معركة بدر؟",
                new Answer[]{
                    new Answer("1000 رجل", true),
                    new Answer("2000 رجل"),
                    new Answer("1500 رجل"),
                    new Answer("900 رجل"),})
        );

        al.add(new Question("ما اسم الصحابي الذي اقترح مكان المعركة في بدر؟",
                new Answer[]{
                    new Answer("الحباب بن المنذر", true),
                    new Answer("عمر بن الخطاب"),
                    new Answer("أبو عبيدة بن الجراح"),
                    new Answer("خالد بن الوليد"),})
        );

        al.add(new Question("من انتصر في معركة بدر؟",
                new Answer[]{
                    new Answer("المسلمون", true),
                    new Answer("المشركون"),
                    new Answer("الشيطان"),
                    new Answer("الباطل"),})
        );

        al.add(new Question("كم عدد أركان الإسلام؟",
                new Answer[]{
                    new Answer("خمسة أركان", true),
                    new Answer("ركنان"),
                    new Answer("ثلاثة أركان"),
                    new Answer("ركن واحد"),})
        );

        al.add(new Question("كان من خلق النبي صلى الله عليه وسلم؟",
                new Answer[]{
                    new Answer("الأمانة ", true),
                    new Answer("الخيانة"),
                    new Answer("الغش"),
                    new Answer("التكبر"),})
        );

        al.add(new Question("من هو الصحابي الذي لقب بالصديق؟",
                new Answer[]{
                    new Answer("أبو بكر", true),
                    new Answer("عثمان بن عفان"),
                    new Answer("أبو عبيدة بن الجراح"),
                    new Answer("أبو هريرة"),})
        );

        al.add(new Question("من هو الصحابي الذي لقب بالفاروق؟",
                new Answer[]{
                    new Answer("عمر بن الخطاب", true),
                    new Answer("سعد بن معاذ"),
                    new Answer("عبدالله بن الزبير"),
                    new Answer("خالد بن الوليد"),})
        );

        al.add(new Question("من هو الصحابي الذي لقب بذي النورين؟",
                new Answer[]{
                    new Answer("عثمان بن عفان", true),
                    new Answer("الزبير بن العوام"),
                    new Answer("حذيفة بن اليمان"),
                    new Answer("أبو صخر"),})
        );

        al.add(new Question("من هو الصحابي الذي لقب بأمين الأمة؟",
                new Answer[]{
                    new Answer("أبو عبيدة بن الجراح", true),
                    new Answer("عامر بن عبدالله"),
                    new Answer("أبو موسى الأشعري"),
                    new Answer("عيينة بن حصين"),})
        );

        al.add(new Question("من هو الصحابي الذي لقب بسيف الله المسلول؟",
                new Answer[]{
                    new Answer("خالد بن الوليد", true),
                    new Answer("الزبير بن العوام"),
                    new Answer("الاقرع بن الحابس"),
                    new Answer("عبدالله بن عباس"),})
        );

        al.add(new Question("من هو الصحابي الذي لقب بأمين السر النبوي؟",
                new Answer[]{
                    new Answer("حذيفة بن اليمان", true),
                    new Answer("ابن مسعود"),
                    new Answer("ابن عمر"),
                    new Answer("عمر بن الخطاب"),})
        );

        al.add(new Question("من هو الصحابي الذي لقب بترجمان القرآن؟",
                new Answer[]{
                    new Answer("عبدالله بن عباس", true),
                    new Answer("الحباب بن المنذر"),
                    new Answer("قتادة"),
                    new Answer("بلال بن رباح"),})
        );

        al.add(new Question("من هو مؤذن رسول الله؟",
                new Answer[]{
                    new Answer("بلال بن رباح", true),
                    new Answer("عطاء بن أبي رباح"),
                    new Answer("أبي بن كعب"),
                    new Answer("زيد بن ثابت"),})
        );

        al.add(new Question("ما هو لقب الرسول صلى الله عليه وسلم؟",
                new Answer[]{
                    new Answer("الصادق الأمين", true),
                    new Answer("التاجر الصدوق"),
                    new Answer("البر الأمين"),
                    new Answer("الأمين الأمين"),})
        );

        al.add(new Question("ما هو عمل الرسول في شبابه؟",
                new Answer[]{
                    new Answer("التجارة", true),
                    new Answer("الزراعة"),
                    new Answer("السياسة"),
                    new Answer("الحياكة"),})
        );

        al.add(new Question("إلى من أرسل الرسول صلى الله عليه وسلم؟",
                new Answer[]{
                    new Answer("إلى كافة الناس", true),
                    new Answer("إلى قريش"),
                    new Answer("إلى بني هاشم"),
                    new Answer("إلى الحجاز"),})
        );

        al.add(new Question("ما الذي جاء به الرسول محمد صلى الله عليه وسلم؟",
                new Answer[]{
                    new Answer("بالشريعة الإسلامية", true),
                    new Answer("باليهودية"),
                    new Answer("بالمجوسية"),
                    new Answer("بالنصرانية"),})
        );

        al.add(new Question("ما أكثر طعام الرسول صلى الله عليه وسلم؟",
                new Answer[]{
                    new Answer("التمر والماء", true),
                    new Answer("اللحم والخبز"),
                    new Answer("الدجاج واللبن"),
                    new Answer("الفاكهة والخضار"),})
        );

        al.add(new Question("كم حجة حج النبي صلى الله عليه وسلم؟",
                new Answer[]{
                    new Answer("حجة واحدة", true),
                    new Answer("حجتان"),
                    new Answer("ثلاث حجات"),
                    new Answer("خمس حجات"),})
        );

        al.add(new Question("كم رمضان صام النبي صلى الله عليه وسلم؟",
                new Answer[]{
                    new Answer("تسع مرات", true),
                    new Answer("ثلاث مرات"),
                    new Answer("خمس مرات"),
                    new Answer("مرتان"),})
        );

        al.add(new Question("ما هي كنية الرسول صلى الله عليه وسلم؟",
                new Answer[]{
                    new Answer("أبو القاسم", true),
                    new Answer("أبو ابراهيم"),
                    new Answer("أبو يوسف"),
                    new Answer("أبو اسماعيل"),})
        );

        al.add(new Question("ما آخر غزوة غزاها الرسول؟",
                new Answer[]{
                    new Answer("غزوة تبوك", true),
                    new Answer("غزوة الخندق"),
                    new Answer("غزوة بدر"),
                    new Answer("غزوة ذات السلاسل"),})
        );

        al.add(new Question("ما هي معجزة النبي الخالدة؟",
                new Answer[]{
                    new Answer("القرآن الكريم", true),
                    new Answer("الانجيل"),
                    new Answer("التوراة"),
                    new Answer("الزبور"),})
        );

        al.add(new Question("متى توفي الرسول صلى الله عليه وسلم؟",
                new Answer[]{
                    new Answer("شهر ربيع الاول عام 11 للهجرة", true),
                    new Answer("شهر صفر عام 14 للهجرة"),
                    new Answer("شهر محرم عام 8 للهجرة"),
                    new Answer("شهر شعبان عام 20 للهجرة"),})
        );

        al.add(new Question("كم كان عمره صلى الله عليه وسلم عند وفاته؟",
                new Answer[]{
                    new Answer("63 سنة", true),
                    new Answer("64 سنة"),
                    new Answer("70 سنة"),
                    new Answer("55 سنة"),})
        );

        al.add(new Question("في أي بلد دفن النبي صلى الله عليه وسلم؟",
                new Answer[]{
                    new Answer("المدينة المنورة", true),
                    new Answer("مكة المكرمة"),
                    new Answer("فلسطين"),
                    new Answer("اليمن"),})
        );

        al.add(new Question("ماذا نسمي معرفة حياة الرسول من ولادته حتى مماته؟",
                new Answer[]{
                    new Answer("السيرة النبوية", true),
                    new Answer("قصة"),
                    new Answer("فيلم وثائقي"),
                    new Answer("رواية"),})
        );

        Collections.shuffle(al);
    }

}
