import java.util.HashMap;

public class DrugInformation {
    private String[] names;
    String[] descriptions;
    String[][] conditions;

    DrugInformation() {
        names = new String[]{"Morphine", "Acetaminophen", "Codeine", "Ibuprofen", "Salbutamol"};
        descriptions = new String[]{"Morphine, the main alkaloid of opium, was first obtained from poppy seeds" +
                " in 1805. It is a potent analgesic, though its use is limited due to tolerance, withdrawal, and the " +
                "risk of abuse. Morphine is still routinely used today, though there are a number of semi-synthetic" +
                " opioids of varying strength such as codeine, fentanyl, methadone, hydrocodone, hydromorphone, " +
                "meperidine, and oxycodone.",
                "Acetaminophen (paracetamol), also commonly known as Tylenol, is the most commonly taken analgesic" +
                        " worldwide and is recommended as first-line therapy in pain conditions by the World Health" +
                        " Organization (WHO). It is also used for its antipyretic effects, helping to reduce fever." +
                        " This drug was initially approved by the U.S. FDA in 1951 and is available in a variety of " +
                        "forms including syrup form, regular tablets, effervescent tablets, injection, suppository, " +
                        "and other forms.\n" + "Acetaminophen is often found combined with other drugs in" +
                        " more than 600 over the counter (OTC) allergy medications, cold medications, sleep medications," +
                        " pain relievers, and other products. Confusion about dosing of this drug may be caused by the" +
                        " availability of different formulas, strengths, and dosage instructions for children of" +
                        " different ages. Due to the possibility of fatal overdose and liver failure associated with " +
                        "the incorrect use of acetaminophen, it is important to follow current and available national" +
                        " and manufacturer dosing guidelines while this drug is taken or prescribed.",
                "The relief of pain (analgesia) is a primary goal for enhancing the quality of life of patients and for" +
                        " increasing the ability of patients to engage in day to day activities. Codeine, an opioid analgesic," +
                        " was originally approved in the US in 1950 and is a drug used to decrease pain by increasing the" +
                        " threshold for pain without impairing consciousness or altering other sensory functions. Opiates such" +
                        " as codeine are derived from the poppy plant, Papaver somniferum (Papaveraceae).\n" + "Codeine is" +
                        " utilized as a central analgesic, sedative, hypnotic, antinociceptive, and antiperistaltic agent, and " +
                        "is also recommended in certain diseases with incessant coughing.",
                "Ibuprofen is a non-steroidal anti-inflammatory drug (NSAID) derived from propionic acid and it is considered" +
                        " the first of the propionics. The formula of ibuprofen is 2-(4-isobutylphenyl) propionic acid and its" +
                        " initial development was in 1960 while researching for a safer alternative for aspirin. Ibuprofen was" +
                        " finally patented in 1961 and this drug was first launched against rheumatoid arthritis in the UK in" +
                        " 1969 and USA in 1974. It was the first available over-the-counter NSAID.\n" + "On the available" +
                        " products, ibuprofen is administered as a racemic mixture. Once administered, the R-enantiomer undergoes" +
                        " extensive interconversion to the S-enantiomer in vivo by the activity of the alpha-methylacyl-CoA" +
                        " racemase. In particular, it is generally proposed that the S-enantiomer is capable of eliciting" +
                        " stronger pharmacological activity than the R-enantiomer.",
                "Salbutamol is a short-acting, selective beta2-adrenergic receptor agonist used in the treatment of asthma and" +
                        " COPD. It is 29 times more selective for beta2 receptors than beta1 receptors giving it higher" +
                        " specificity for pulmonary beta receptors versus beta1-adrenergic receptors located in the heart." +
                        " Salbutamol is formulated as a racemic mixture of the R- and S-isomers. The R-isomer has 150 times" +
                        " greater affinity for the beta2-receptor than the S-isomer and the S-isomer has been associated with" +
                        " toxicity. This lead to the development of levalbuterol, the single R-isomer of salbutamol. However," +
                        " the high cost of levalbuterol compared to salbutamol has deterred wide-spread use of this" +
                        " enantiomerically pure version of the drug. Salbutamol is generally used for acute episodes of" +
                        " bronchospasm caused by bronchial asthma, chronic bronchitis and other chronic bronchopulmonary" +
                        " disorders such as chronic obstructive pulmonary disorder (COPD). It is also used prophylactically " +
                        "for exercise-induced asthma."};
        String[] array1 = new String[]{"Pain, Chronic", "Severe Pain"};
        String[] array2 = new String[]{"Allergies", "Coughing", "Common Cold/Flu", "Headache", "Muscle Injuries"};
        String[] array3 = new String[]{"Common Cold", "Coughing", "Pain", "Upper respiratory symptoms", "Flu caused by Influenza"};
        String[] array4 = new String[]{"Fever", "Sinus Pressure", "Migraine", "Menstrual Cramps", "Osteoarthritis"};
        String[] array5 = new String[]{"Asthma", "Chronic Bronchitis", "Emphysema"};
        conditions = new String[][] { array1, array2, array3, array4, array5 };
    }

    public String findMatches(String text) {
        String drugName = "";
        for (int i = 0; i < 5; i++) {
            if (names[i].toLowerCase().equals(text.toLowerCase())) {
                drugName = names[i];
            }
        }
        return drugName;
    }

    public String getDescription(String text) {
        int index = 0;
        for (int i = 0; i < 5; i++) {
            if (names[i].toLowerCase().equals(text.toLowerCase())) {
                index = i;
            }
        }
        return descriptions[index];
    }

    public String[] getConditions(String text) {
        int index = 0;
        for (int i = 0; i < 5; i++) {
            if (names[i].toLowerCase().equals(text.toLowerCase())) {
                index = i;
            }
        }
        return conditions[index];
    }
}
