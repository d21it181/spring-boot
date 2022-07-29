package in.ac.charusat.studentmgmtsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Result {



        @Id
        private Integer id;
        private String name;
        private float percent;

        public Result (Integer id, String name, float percent) {
            this.id = id;
            this.name = name;
            this.percent = percent;
        }

        public Result () {

        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getPercent() {
            return percent;
        }

        public void setPercent(float percent) { this.percent = percent;}
    }


