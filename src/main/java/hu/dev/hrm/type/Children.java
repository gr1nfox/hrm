package hu.dev.hrm.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Children {
    private List<Child> children;

    public Children() {
    }

    public Children(List<Child> children) {
        this.children = children;
    }

    public int getChildrenSize() {
        return children.size();
    }
}
