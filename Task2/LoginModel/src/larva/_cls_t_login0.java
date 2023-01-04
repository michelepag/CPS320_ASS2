package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_t_login0 implements _callable{

public static PrintWriter pw; 
public static _cls_t_login0 root;

public static LinkedHashMap<_cls_t_login0,_cls_t_login0> _cls_t_login0_instances = new LinkedHashMap<_cls_t_login0,_cls_t_login0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\miche\\Desktop\\school\\year 3\\software testing\\Tutorial\\LoginModel/src/output_t_login.txt");

root = new _cls_t_login0();
_cls_t_login0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_t_login0 parent; //to remain null - this class does not have a parent!
public static boolean v;
public static boolean value;
int no_automata = 1;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_t_login0() {
}

public void initialisation() {
}

public static _cls_t_login0 _get_cls_t_login0_inst() { synchronized(_cls_t_login0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_t_login0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_t_login0_instances){
_performLogic_LoginModelProperty(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_t_login0[] a = new _cls_t_login0[1];
synchronized(_cls_t_login0_instances){
a = _cls_t_login0_instances.keySet().toArray(a);}
for (_cls_t_login0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_t_login0_instances){
_cls_t_login0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_LoginModelProperty = 38;

public void _performLogic_LoginModelProperty(String _info, int... _event) {

_cls_t_login0.pw.println("[LoginModelProperty]AUTOMATON::> LoginModelProperty("+") STATE::>"+ _string_LoginModelProperty(_state_id_LoginModelProperty, 0));
_cls_t_login0.pw.flush();

if (0==1){}
else if (_state_id_LoginModelProperty==37){
		if (1==0){}
		else if ((_occurredEvent(_event,62/*log_out*/)) && (v ==false )){
		;
_cls_t_login0.pw .println ("Successful Logout observed");

		_state_id_LoginModelProperty = 38;//moving to state loggedout
		_goto_LoginModelProperty(_info);
		}
		else if ((_occurredEvent(_event,62/*log_out*/)) && (v ==true )){
		;
_cls_t_login0.pw .println ("Bad logout observed.");

		_state_id_LoginModelProperty = 36;//moving to state bad_state
		_goto_LoginModelProperty(_info);
		}
}
else if (_state_id_LoginModelProperty==38){
		if (1==0){}
		else if ((_occurredEvent(_event,60/*login*/)) && (value ==false )){
		;
_cls_t_login0.pw .println ("Invalid login observed");

		_state_id_LoginModelProperty = 38;//moving to state loggedout
		_goto_LoginModelProperty(_info);
		}
		else if ((_occurredEvent(_event,60/*login*/)) && (value ==true )){
		;
_cls_t_login0.pw .println ("Valid login");

		_state_id_LoginModelProperty = 37;//moving to state loggedin
		_goto_LoginModelProperty(_info);
		}
}
}

public void _goto_LoginModelProperty(String _info){
_cls_t_login0.pw.println("[LoginModelProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_LoginModelProperty(_state_id_LoginModelProperty, 1));
_cls_t_login0.pw.flush();
}

public String _string_LoginModelProperty(int _state_id, int _mode){
switch(_state_id){
case 37: if (_mode == 0) return "loggedin"; else return "loggedin";
case 38: if (_mode == 0) return "loggedout"; else return "loggedout";
case 36: if (_mode == 0) return "bad_state"; else return "!!!SYSTEM REACHED BAD STATE!!! bad_state "+new _BadStateExceptiont_login().toString()+" ";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}