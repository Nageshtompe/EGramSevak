import { Village } from "./Village";

export class Scheme{
    id:number;
    schemeStartDate:Date;
    expDate:Date;
    schemeShortName:String;
    schemeDesc:string;
    village:Village[]=[];
}