package study.practice.domain.repo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DmsDto {
    private List<Role> roles;


    @Data
    @NoArgsConstructor
    public static class Role{
        private String roleName;
        private String roleId;

        @Builder
        public Role(String roleName, String roleId) {
            this.roleName = roleName;
            this.roleId = roleId;
        }
    }
}
