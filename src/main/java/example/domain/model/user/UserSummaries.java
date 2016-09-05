package example.domain.model.user;

import java.util.Collections;
import java.util.List;

public class UserSummaries {
    final List<UserSummary> values;

    public UserSummaries(List<UserSummary> values) {
        this.values = values;
    }

    public List<UserSummary> list() {
        return Collections.unmodifiableList(values);
    }

}
