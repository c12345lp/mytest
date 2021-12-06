package enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {
    private String nId,nTid,NTitle,nAuthor,NCreatDate,nPicPath,NContent,nModifyDate,nSummary;

    public void NCreatDate() {
    }
}
