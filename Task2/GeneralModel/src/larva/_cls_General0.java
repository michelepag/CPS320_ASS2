package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_General0 implements _callable{

public static PrintWriter pw; 
public static _cls_General0 root;

public static LinkedHashMap<_cls_General0,_cls_General0> _cls_General0_instances = new LinkedHashMap<_cls_General0,_cls_General0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\miche\\Desktop\\school\\year 3\\software testing\\Tutorial\\GeneralModel/src/output_General.txt");

root = new _cls_General0();
_cls_General0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_General0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;
 public int badLogins =0 ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_General0() {
}

public void initialisation() {
}

public static _cls_General0 _get_cls_General0_inst() { synchronized(_cls_General0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_General0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_General0_instances){
_performLogic_GeneralModelProperty(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_General0[] a = new _cls_General0[1];
synchronized(_cls_General0_instances){
a = _cls_General0_instances.keySet().toArray(a);}
for (_cls_General0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_General0_instances){
_cls_General0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_GeneralModelProperty = 11;

public void _performLogic_GeneralModelProperty(String _info, int... _event) {

_cls_General0.pw.println("[GeneralModelProperty]AUTOMATON::> GeneralModelProperty("+") STATE::>"+ _string_GeneralModelProperty(_state_id_GeneralModelProperty, 0));
_cls_General0.pw.flush();

if (0==1){}
else if (_state_id_GeneralModelProperty==9){
		if (1==0){}
		else if ((_occurredEvent(_event,14/*log_in*/))){
		;
_cls_General0.pw .println ("User logged in");

		_state_id_GeneralModelProperty = 11;//moving to state login
		_goto_GeneralModelProperty(_info);
		}
		else if ((_occurredEvent(_event,20/*delete_alerts*/))){
		;
_cls_General0.pw .println ("Alerts deleted");

		_state_id_GeneralModelProperty = 10;//moving to state alerts_deleted
		_goto_GeneralModelProperty(_info);
		}
		else if ((_occurredEvent(_event,22/*view_alerts*/))){
		;
_cls_General0.pw .println ("User viewed alerts");

		_state_id_GeneralModelProperty = 8;//moving to state alerts_viewed
		_goto_GeneralModelProperty(_info);
		}
		else if ((_occurredEvent(_event,18/*create_alert*/))){
		;
_cls_General0.pw .println ("Alerts created");

		_state_id_GeneralModelProperty = 9;//moving to state alerts_created
		_goto_GeneralModelProperty(_info);
		}
		else if ((_occurredEvent(_event,16/*log_out*/))){
		;
_cls_General0.pw .println ("User logged out");

		_state_id_GeneralModelProperty = 7;//moving to state logout
		_goto_GeneralModelProperty(_info);
		}
}
else if (_state_id_GeneralModelProperty==7){
		if (1==0){}
		else if ((_occurredEvent(_event,14/*log_in*/))){
		;
_cls_General0.pw .println ("User logged in");

		_state_id_GeneralModelProperty = 11;//moving to state login
		_goto_GeneralModelProperty(_info);
		}
		else if ((_occurredEvent(_event,18/*create_alert*/))){
		;
_cls_General0.pw .println ("An alert has been uploaded and user is logged out");

		_state_id_GeneralModelProperty = 9;//moving to state alerts_created
		_goto_GeneralModelProperty(_info);
		}
		else if ((_occurredEvent(_event,20/*delete_alerts*/))){
		;
_cls_General0.pw .println ("Alerts deleted and user is logged out");

		_state_id_GeneralModelProperty = 10;//moving to state alerts_deleted
		_goto_GeneralModelProperty(_info);
		}
}
else if (_state_id_GeneralModelProperty==11){
		if (1==0){}
		else if ((_occurredEvent(_event,22/*view_alerts*/))){
		;
_cls_General0.pw .println ("User viewed alerts");

		_state_id_GeneralModelProperty = 8;//moving to state alerts_viewed
		_goto_GeneralModelProperty(_info);
		}
		else if ((_occurredEvent(_event,18/*create_alert*/))){
		;
_cls_General0.pw .println ("Alert created and user is logged in");

		_state_id_GeneralModelProperty = 9;//moving to state alerts_created
		_goto_GeneralModelProperty(_info);
		}
		else if ((_occurredEvent(_event,20/*delete_alerts*/))){
		;
_cls_General0.pw .println ("Alerts deleted and user is logged in");

		_state_id_GeneralModelProperty = 10;//moving to state alerts_deleted
		_goto_GeneralModelProperty(_info);
		}
		else if ((_occurredEvent(_event,16/*log_out*/))){
		;
_cls_General0.pw .println ("User logged out");

		_state_id_GeneralModelProperty = 7;//moving to state logout
		_goto_GeneralModelProperty(_info);
		}
}
else if (_state_id_GeneralModelProperty==10){
		if (1==0){}
		else if ((_occurredEvent(_event,14/*log_in*/))){
		;
_cls_General0.pw .println ("User logged in");

		_state_id_GeneralModelProperty = 11;//moving to state login
		_goto_GeneralModelProperty(_info);
		}
		else if ((_occurredEvent(_event,20/*delete_alerts*/))){
		;
_cls_General0.pw .println ("Alerts deleted");

		_state_id_GeneralModelProperty = 10;//moving to state alerts_deleted
		_goto_GeneralModelProperty(_info);
		}
		else if ((_occurredEvent(_event,18/*create_alert*/))){
		;
_cls_General0.pw .println ("Alerts created");

		_state_id_GeneralModelProperty = 9;//moving to state alerts_created
		_goto_GeneralModelProperty(_info);
		}
		else if ((_occurredEvent(_event,16/*log_out*/))){
		;
_cls_General0.pw .println ("User logged out");

		_state_id_GeneralModelProperty = 7;//moving to state logout
		_goto_GeneralModelProperty(_info);
		}
		else if ((_occurredEvent(_event,22/*view_alerts*/))){
		;
_cls_General0.pw .println ("User viewed alerts");

		_state_id_GeneralModelProperty = 8;//moving to state alerts_viewed
		_goto_GeneralModelProperty(_info);
		}
}
else if (_state_id_GeneralModelProperty==8){
		if (1==0){}
		else if ((_occurredEvent(_event,16/*log_out*/))){
		;
_cls_General0.pw .println ("User logged out");

		_state_id_GeneralModelProperty = 7;//moving to state logout
		_goto_GeneralModelProperty(_info);
		}
		else if ((_occurredEvent(_event,18/*create_alert*/))){
		;
_cls_General0.pw .println ("An alert has been uploaded");

		_state_id_GeneralModelProperty = 9;//moving to state alerts_created
		_goto_GeneralModelProperty(_info);
		}
		else if ((_occurredEvent(_event,20/*delete_alerts*/))){
		;
_cls_General0.pw .println ("Alerts deleted");

		_state_id_GeneralModelProperty = 10;//moving to state alerts_deleted
		_goto_GeneralModelProperty(_info);
		}
		else if ((_occurredEvent(_event,22/*view_alerts*/))){
		;
_cls_General0.pw .println ("User viewed alerts");

		_state_id_GeneralModelProperty = 8;//moving to state alerts_viewed
		_goto_GeneralModelProperty(_info);
		}
}
}

public void _goto_GeneralModelProperty(String _info){
_cls_General0.pw.println("[GeneralModelProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_GeneralModelProperty(_state_id_GeneralModelProperty, 1));
_cls_General0.pw.flush();
}

public String _string_GeneralModelProperty(int _state_id, int _mode){
switch(_state_id){
case 9: if (_mode == 0) return "alerts_created"; else return "alerts_created";
case 6: if (_mode == 0) return "error_state"; else return "!!!SYSTEM REACHED BAD STATE!!! error_state "+new _BadStateExceptionGeneral().toString()+" ";
case 7: if (_mode == 0) return "logout"; else return "logout";
case 11: if (_mode == 0) return "login"; else return "login";
case 10: if (_mode == 0) return "alerts_deleted"; else return "alerts_deleted";
case 8: if (_mode == 0) return "alerts_viewed"; else return "alerts_viewed";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}