package com.aquari.gymapplication;

import java.util.ArrayList;

public class Utils {
    private static ArrayList<Training> trainings;
    private static ArrayList<Plan> plans;
    public static ArrayList<Training> getTrainings() {
        return trainings;
    }

    public static void initTrainings(){
        if(trainings==null){
            trainings=new ArrayList<>();
        }
        Training pushUp = new Training(1, "Push up","The push-up (sometimes called a press-up in British English) is a common calisthenics exercise beginning from the prone position",
                "By raising and lowering the body using the arms, push-ups exercise the pectoral muscles, triceps, and anterior deltoids, with ancillary benefits to the rest of the deltoids, serratus anterior, coracobrachialis and the midsection as a whole.[1] Push-ups are a basic exercise used in civilian athletic training or physical education and commonly in military physical training. They are also a common form of punishment used in the military, school sport, and some martial arts disciplines.",
                "https://www.runtastic.com/blog/wp-content/uploads/2019/02/533_do-your-first-push-up_ft.jpg");
        trainings.add(pushUp);

        Training squat = new Training(2,"Squat","A squat is a strength exercise in which the trainee lowers their hips from a standing position and then stands back up.",
                "Squats are considered a vital exercise for increasing the strength and size of the lower body muscles as well as developing core strength. The primary agonist muscles used during the squat are the quadriceps femoris, the adductor magnus, and the gluteus maximus.",
                "https://blog.myfitnesspal.com/wp-content/uploads/2021/08/A-Beginners-Guide-to-the-Squat-1200x900.jpg");
        trainings.add(squat);

        Training legPress=new Training(3,"Leg Press","The leg press is a compound weight training exercise in which the individual pushes a weight or resistance away from them using their legs.",
                "The term leg press machine refers to the apparatus used to perform this exercise.[1] The leg press can be used to evaluate an athlete's overall lower body strength (from the gluteus Maximus to the lower leg muscles). It can help to build squat strength.[2] ",
                "https://blog.squatwolf.com/wp-content/uploads/2018/05/shutterstock_215163556-min.jpg");
        trainings.add(legPress);

        Training pullUps = new Training(4,"Pull-ups","An exercise involving raising oneself with one's arms",
                "A pull-up is an upper-body strength exercise. The pull-up is a closed-chain movement where the body is suspended by the hands, gripping a bar or other implement at a distance typically wider than shoulder-width, and pulled up.",
                "https://static01.nyt.com/images/2022/04/07/well/07well-pull-ups2/merlin_203413908_ac2bfdbe-0c81-406a-86f7-d738893bdd06-mobileMasterAt3x.jpg");
        trainings.add(pullUps);

        Training pectorals = new Training(5,"Pectorals","Amazing for building chest muscles",
                "Your pectoral muscles are one of the largest muscle groups in your upper body. They pull on the humerus (upper arm bone), allowing you to make vertical, horizontal, and rotational movements with your arms",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRiAoNM9Jcp0gVJr82mpfeNd7vvzJx6D5jzcA&usqp=CAU");
        trainings.add(pectorals);


    }

    public static boolean addPlan(Plan plan){
        if(plans==null){
            plans = new ArrayList<>();

        }
        return plans.add(plan);
    }

    public static ArrayList<Plan> getPlans() {
        return plans;
    }
}
